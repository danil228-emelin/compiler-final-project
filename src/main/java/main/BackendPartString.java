package main;

import org.antlr.v4.runtime.Token;

import java.util.HashSet;
import java.util.Set;

import static main.Compiler.*;

public class BackendPartString extends GrammarMinilangBaseVisitor<String> {


    public static boolean IsKeyExistInMemoryString(String key) {
        return MEMORY_STRING.containsKey(key);
    }

    private static String current_register = "";
    //x1- register for returning values from different kind of expr
    //x2- register for keeping first value of different kind of expr
    //x3- register for keeping second value of different kind of expr
    //x4- register for temp values during processing expressions

    private HashSet<String> USED_REGISTER = new HashSet<>(Set.of("x1", "x2", "x3", "x4"));

    private String allocateRegister() {
        for (int i = 1; i <= 31; i++) {
            String reg = "x" + i;
            if (!USED_REGISTER.contains(reg)) {
                USED_REGISTER.add(reg);
                return reg;
            }
        }
        throw new RuntimeException("No free registers available");
    }

    private void freeRegister(String reg) {
        USED_REGISTER.remove(reg);
    }

    private void throwError(GrammarMinilangParser.StatContext ctx, String message) {
        Token token = ctx.getStart();
        String fileName = token.getTokenSource().getSourceName();
        int lineNumber = token.getLine();
        int charPosition = token.getCharPositionInLine();

        throw new RuntimeException(String.format(
                "Assignment error at %s:%d:%d.\n%s",
                fileName,
                lineNumber,
                charPosition,
                message));
    }

    private boolean isNum(String num) {
        if (num == null) return false;
        return num.matches("-?\\d+");
    }


    @Override
    public String visitAssign(GrammarMinilangParser.AssignContext ctx) {
        var assignContext = ctx.getChild(0);
        String variableName = assignContext.getChild(0).getText();
        String value = visit(ctx.assignSt().expr());
        String register = "x1";

        if (MEMORY_STRING.containsKey(variableName)) {
            RISC_CODE.add("la a0, " + value + "_str\n");
            RISC_CODE.add("mv a1, " + value + "\n");
            RISC_CODE.add("jal ra, strcpy"); // Вызываем функцию копирования строк
            freeRegister(register);
            return "visitAssign";
        } else if (MEMORY_INTEGER.containsKey(variableName)) {
            if (!isNum(value)) {
                throwError(ctx, String.format("Can't assign int variable %s. value '%s'\n", variableName, value));
            }
            MEMORY_INTEGER.put(variableName, value);
            register = VARIABLE_REGISTER__MAP.get(variableName);
            RISC_CODE.add(String.format("# save value %s of variable %s into %s register", value, variableName, register));
            RISC_CODE.add("li " + register + ", " + value);
            current_register = register;
            return "visitAssign";

        }
        throwError(ctx, String.format("Variable '%s' not found\n", variableName));
        return "visitAssign";
    }


    @Override
    public String visitIfStatement(GrammarMinilangParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public String visitWhileStatement(GrammarMinilangParser.WhileStatementContext ctx) {
        return super.visitWhileStatement(ctx);
    }


    @Override
    public String visitDeclaration(GrammarMinilangParser.DeclarationContext ctx) {
        var assignContext = ctx.variable_decl();
        String newVariable = assignContext.getChild(1).getText();
        String type = assignContext.getChild(3).getText();
        if (MEMORY_STRING.containsKey(newVariable) || MEMORY_INTEGER.containsKey(newVariable)) {
            throwError(ctx, String.format("Variable %s already defined\n", newVariable));
        }
        if (type.equals("string")) {
            MEMORY_STRING.put(newVariable, "");
        } else if (type.equals("int")) {
            MEMORY_INTEGER.put(newVariable, "0");
            String reg = allocateRegister();
            VARIABLE_REGISTER__MAP.put(newVariable, reg);
            RISC_CODE.add(String.format("# declare %s into %s register", newVariable, reg));
            RISC_CODE.add("li " + reg + ", 0");
        } else {
            throwError(ctx, String.format("Unsupported %s type\n", type));
        }
        return "visitDeclaration";
    }

    @Override
    public String visitPrintSmth(GrammarMinilangParser.PrintSmthContext ctx) {
        return super.visitPrintSmth(ctx);
    }

    @Override
    public String visitWhileStat(GrammarMinilangParser.WhileStatContext ctx) {
        return super.visitWhileStat(ctx);
    }

    @Override
    public String visitIfStat(GrammarMinilangParser.IfStatContext ctx) {
        return super.visitIfStat(ctx);
    }

    @Override
    public String visitMultiple_logic_block(GrammarMinilangParser.Multiple_logic_blockContext ctx) {
        return super.visitMultiple_logic_block(ctx);
    }

    @Override
    public String visitSingle_logic_block(GrammarMinilangParser.Single_logic_blockContext ctx) {
        return super.visitSingle_logic_block(ctx);
    }


    @Override
    public String visitMinValue(GrammarMinilangParser.MinValueContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;
        if (!operator.getText().equals("min")) {
            throw new RuntimeException("visitMinValue: Wrong operator name. Must be min");
        }
        String value1 = visit(exp1);
        String value2 = visit(exp2);
        if (!isNum(value1)) {
            throw new RuntimeException(String.format("visitMinValue. Can't execute. First argument isn't number %s", value1));
        }
        if (!isNum(value2)) {
            throw new RuntimeException(String.format("visitMinValue. Can't execute. Second argument isn't number %s", value2));
        }

        RISC_CODE.add("# start min operation");
        RISC_CODE.add("# put first value into x2 register");
        RISC_CODE.add(String.format("li x2, %s", value1));
        RISC_CODE.add("# put second value into x3 register");
        RISC_CODE.add(String.format("li x3, %s", value2));
        RISC_CODE.add("# x1 = (x2 < x3) ? 1 : 0");
        RISC_CODE.add("slt x1, x2, x3");
        RISC_CODE.add("# x4 = (x1 == 1) ? -1 : 0 (маска)");
        RISC_CODE.add("li x4, 0");
        RISC_CODE.add("sub x4, x0, x1");
        RISC_CODE.add(String.format("# if x4 == 1 then first argument(x2) is min. %s ", value1));
        RISC_CODE.add("and x2, x2, x4");
        RISC_CODE.add("# invert mask ");
        RISC_CODE.add("not x4,x4");
        RISC_CODE.add(String.format("# if x4 == 0 then second argument(x3) is min. %s ", value2));
        RISC_CODE.add("and x3, x3, x4");
        RISC_CODE.add("# put result into x1");
        RISC_CODE.add("li x1, 0");
        RISC_CODE.add("or x1, x2, x3");

        return String.valueOf(Math.min(Integer.parseInt(value1), Integer.parseInt(value2)));
    }

    @Override
    public String visitLogicalNot(GrammarMinilangParser.LogicalNotContext ctx) {
        String exprValue = visit(ctx.expr());

        if (!isNum(exprValue)) {
            throw new RuntimeException(String.format(
                    "Logical NOT requires numeric argument, got: %s", exprValue));
        }

        RISC_CODE.add("# logical NOT operation");
        RISC_CODE.add("# load value into x2");
        RISC_CODE.add(String.format("li x2, %s", exprValue));

        RISC_CODE.add("#  x1 = (x2 == 0) ? 1 : 0");

        RISC_CODE.add("seqz x1, x2");

        boolean result = Integer.parseInt(exprValue) == 0;
        return String.valueOf(result ? 1 : 0);
    }

    @Override
    public String visitLogicalAnd(GrammarMinilangParser.LogicalAndContext ctx) {
        String leftValue = visit(ctx.expr(0));
        String rightValue = visit(ctx.expr(1));

        // Проверка типов
        if (!isNum(leftValue) || !isNum(rightValue)) {
            throw new RuntimeException(String.format(
                    "Logical AND requires numeric arguments, got: %s and %s",
                    leftValue, rightValue));
        }

        RISC_CODE.add("# logical AND operation");

        RISC_CODE.add("# load left value into x2");
        RISC_CODE.add(String.format("li x2, %s", leftValue));
        RISC_CODE.add("# load right value into x3");
        RISC_CODE.add(String.format("li x3, %s", rightValue));
        RISC_CODE.add("# x1 = (x2 != 0 && x3 != 0) ? 1 : 0");
        RISC_CODE.add("snez x2, x2");
        RISC_CODE.add("snez x3, x3");
        RISC_CODE.add("and x1, x2, x3");

        boolean result = Integer.parseInt(leftValue) != 0 &&
                Integer.parseInt(rightValue) != 0;
        return String.valueOf(result ? 1 : 0);
    }

    @Override
    public String visitAddSub(GrammarMinilangParser.AddSubContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;

        if (!operator.getText().equals("+") && !operator.getText().equals("-")) {
            throw new RuntimeException("visitAddSub: Wrong operator. Must be + or -");
        }

        String value1 = visit(exp1);
        String value2 = visit(exp2);

        if (!isNum(value1)) {
            throw new RuntimeException(String.format(
                    "visitAddSub: First argument isn't a number: %s", value1));
        }
        if (!isNum(value2)) {
            throw new RuntimeException(String.format(
                    "visitAddSub: Second argument isn't a number: %s", value2));
        }

        RISC_CODE.add("# start " + operator.getText() + " operation");

        RISC_CODE.add("# load first value into x2");
        RISC_CODE.add(String.format("li x2, %s", value1));

        RISC_CODE.add("# load second value into x3");
        RISC_CODE.add(String.format("li x3, %s", value2));

        if (operator.getText().equals("+")) {
            RISC_CODE.add("# x1 = x2 + x3");
            RISC_CODE.add("add x1, x2, x3");
        } else {
            RISC_CODE.add("# x1 = x2 - x3");
            RISC_CODE.add("sub x1, x2, x3");
        }

        // Возвращаем результат вычислений
        int result = operator.getText().equals("+")
                ? Integer.parseInt(value1) + Integer.parseInt(value2)
                : Integer.parseInt(value1) - Integer.parseInt(value2);

        return String.valueOf(result);

    }

    @Override
    public String visitRelational(GrammarMinilangParser.RelationalContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;

        String opText = operator.getText();
        if (!Set.of("<", ">", "<=", ">=").contains(opText)) {
            throw new RuntimeException("visitRelational: Invalid operator. Must be <, >, <=, or >=");
        }

        String value1 = visit(exp1);
        String value2 = visit(exp2);

        if (!isNum(value1)) {
            throw new RuntimeException(String.format(
                    "visitRelational: First argument isn't a number: %s", value1));
        }
        if (!isNum(value2)) {
            throw new RuntimeException(String.format(
                    "visitRelational: Second argument isn't a number: %s", value2));
        }

        RISC_CODE.add("# start relational operation " + opText);

        RISC_CODE.add("# load first value into x2");
        RISC_CODE.add(String.format("li x2, %s", value1));

        RISC_CODE.add("# load second value into x3");
        RISC_CODE.add(String.format("li x3, %s", value2));


        switch (opText) {
            case "<":
                RISC_CODE.add("# x1 = (x2 < x3) ? 1 : 0");
                RISC_CODE.add("slt x1, x2, x3");
                break;
            case ">":
                RISC_CODE.add("# x1 = (x2 > x3) ? 1 : 0");
                RISC_CODE.add("slt x1, x3, x2");
                break;
            case "<=":
                RISC_CODE.add("# x1 = (x2 <= x3) ? 1 : 0");
                RISC_CODE.add("slt x1, x3, x2");
                RISC_CODE.add("xori x1, x1, 1");
                break;
            case ">=":
                RISC_CODE.add("# x1 = (x2 >= x3) ? 1 : 0");
                RISC_CODE.add("slt x1, x2, x3");
                RISC_CODE.add("xori x1, x1, 1");
                break;
        }

        // Calculate boolean result for return
        int num1 = Integer.parseInt(value1);
        int num2 = Integer.parseInt(value2);
        boolean result;
        switch (opText) {
            case "<":
                result = num1 < num2;
                break;
            case ">":
                result = num1 > num2;
                break;
            case "<=":
                result = num1 <= num2;
                break;
            case ">=":
                result = num1 >= num2;
                break;
            default:
                throw new AssertionError();
        }

        return String.valueOf(result ? 1 : 0);  // RISC-V uses 1/0 for true/false
    }

    @Override
    public String visitId(GrammarMinilangParser.IdContext ctx) {
        var id = ctx.getChild(0).getText();
        if (MEMORY_STRING.containsKey(id)) {
            return MEMORY_STRING.get(id);
        }
        if (MEMORY_INTEGER.containsKey(id)) {
            String value = MEMORY_INTEGER.get(id);
            String register = VARIABLE_REGISTER__MAP.get(id);
            RISC_CODE.add(String.format("# take value %s from register %s(store %s)", value, register, id));
            return value;
        }
        throw new RuntimeException(String.format("variable doesn't exist %s\n", id));
    }

    @Override
    public String visitLogicalOr(GrammarMinilangParser.LogicalOrContext ctx) {
        return super.visitLogicalOr(ctx);
    }

    @Override
    public String visitValue(GrammarMinilangParser.ValueContext ctx) {
        var string_rep = ctx.op.getText();
        if (isNum(string_rep)) {
            return string_rep;
        }
        throw new RuntimeException("visitValue: Can't assing strings yet");
    }

    @Override
    public String visitEquality(GrammarMinilangParser.EqualityContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;

        String value1 = visit(exp1);
        String value2 = visit(exp2);

        RISC_CODE.add("# equality operation " + operator.getText());

        // Загрузка значений в регистры
        RISC_CODE.add("# load first value into x2");
        RISC_CODE.add(String.format("li x2, %s", value1));
        RISC_CODE.add("# load second value into x3");
        RISC_CODE.add(String.format("li x3, %s", value2));

        if (operator.getText().equals("==")) {
            RISC_CODE.add("# x1 = (x2 == x3) ? 1 : 0");
            RISC_CODE.add("xor x1, x2, x3");
            RISC_CODE.add("seqz x1, x1");
        } else {
            RISC_CODE.add("# x1 = (x2 != x3) ? 1 : 0");
            RISC_CODE.add("xor x1, x2, x3");
            RISC_CODE.add("snez x1, x1");
        }

        // Вычисление результата для семантического анализа
        boolean result = operator.getText().equals("==")
                ? value1.equals(value2)
                : !value1.equals(value2);

        return String.valueOf(result ? 1 : 0);
    }

    @Override
    public String visitMulDiv(GrammarMinilangParser.MulDivContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;

        if (!operator.getText().equals("*") && !operator.getText().equals("/")) {
            throw new RuntimeException("visitMulDiv: Wrong operator. Must be * or /");
        }

        String value1 = visit(exp1);
        String value2 = visit(exp2);

        if (!isNum(value1)) {
            throw new RuntimeException(String.format(
                    "visitMulDiv: First argument isn't a number: %s", value1));
        }
        if (!isNum(value2)) {
            throw new RuntimeException(String.format(
                    "visitMulDiv: Second argument isn't a number: %s", value2));
        }

        RISC_CODE.add("# start " + operator.getText() + " operation");

        RISC_CODE.add("# load first value into x2");
        RISC_CODE.add(String.format("li x2, %s", value1));

        RISC_CODE.add("# load second value into x3");
        RISC_CODE.add(String.format("li x3, %s", value2));

        if (operator.getText().equals("*")) {
            RISC_CODE.add("# x1 = x2 * x3");
            RISC_CODE.add("mul x1, x2, x3");
        } else {
            if (value2.equals("0")) {
                throw new RuntimeException("Error. Division by zero");
            }
            RISC_CODE.add("# x1 = x2 / x3");
            RISC_CODE.add("div x1, x2, x3");
        }

        int result = operator.getText().equals("*")
                ? Integer.parseInt(value1) * Integer.parseInt(value2)
                : Integer.parseInt(value1) / Integer.parseInt(value2);

        return String.valueOf(result);
    }


    @Override
    public String visitPrintExpr(GrammarMinilangParser.PrintExprContext ctx) {
        String exprValue = visit(ctx.expr());

        RISC_CODE.add("# print expression result");

        if (!isNum(exprValue)) {
            throw new RuntimeException(String.format(
                    "visitPrintExpr: argument isn't a number: %s", exprValue));

        }
        RISC_CODE.add("# load integer value into a0");
        RISC_CODE.add(String.format("li a0, %s", exprValue));

        RISC_CODE.add("# prepare syscall for printing integer");
        RISC_CODE.add("li a7, 1");
        RISC_CODE.add("ecall");
        RISC_CODE.add("# print newline");
        RISC_CODE.add("li a0, 10");
        RISC_CODE.add("li a7, 11");
        RISC_CODE.add("ecall");
        return exprValue;
    }


    @Override
    public String visitPrintString(GrammarMinilangParser.PrintStringContext ctx) {
        throw new RuntimeException("Currently not supported");
        //return super.visitPrintString(ctx);
    }

    @Override
    public String visitLeft_expr(GrammarMinilangParser.Left_exprContext ctx) {
        //Need to rewrite when become more than 1 option in grammar for left_expr.
        return super.visitLeft_expr(ctx);
    }

}
