package main;

import org.antlr.v4.runtime.Token;

import java.util.HashSet;
import java.util.Set;

import static main.Compiler.*;

public class BackendPart extends GrammarMinilangBaseVisitor<String> {
    private static class WhileInfo {
        String while_statement_register_holder = "";
        String while_statement_value = "";
    }

    public static boolean IsKeyExistInMemoryString(String key) {
        return MEMORY_STRING.containsKey(key);
    }

    private static WhileInfo whileInfo = new WhileInfo();
    //x1- register for returning values from different kind of expr
    //x2- register for keeping first value of different kind of expr
    //x3- register for keeping second value of different kind of expr
    //x4- register for temp values during processing expressions
    private static int labelCounter = 1;
    private static int String_unique_id_for_decl = 1;

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
            RISC_CODE.add("la x0, " + value + "_str\n");
            RISC_CODE.add("mv x1, " + value + "\n");
            RISC_CODE.add("jal ra, strcpy");
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
            return "visitAssign";

        }
        throwError(ctx, String.format("Variable '%s' not found\n", variableName));
        return "visitAssign";
    }


    @Override
    public String visitIfStatement(GrammarMinilangParser.IfStatementContext ctx) {
        String elseLabel = "else_" + labelCounter++;
        String endLabel = "endif_" + labelCounter++;

        String condValue = visit(ctx.ifStat().expr());
        RISC_CODE.add("# if condition evaluation");
        int condValueInt = Integer.parseInt(condValue);
        if (!isNum(condValue)) {
            throw new RuntimeException("If condition must be numeric expression");
        }
        var ifBlock = ctx.ifStat().block(0);
        var elseBlock = ctx.ifStat().block(1);
        System.out.println(ifBlock.getText());
        System.out.println(ctx.getText());


        RISC_CODE.add("# load condition value");
        RISC_CODE.add(String.format("li x2, %s", condValue));
        RISC_CODE.add("beqz x2, " + (elseBlock != null ? elseLabel : endLabel));
        if (condValueInt > 0) {
            RISC_CODE.add("# execute then block");
            visit(ifBlock);
        } else if (elseBlock != null) {
            RISC_CODE.add("j " + endLabel);
            RISC_CODE.add(elseLabel + ":");
            RISC_CODE.add("# execute else block");
            visit(elseBlock);
        }
        RISC_CODE.add(endLabel + ":");
        RISC_CODE.add("# end if");

        return "";
    }

    @Override
    public String visitWhileStatement(GrammarMinilangParser.WhileStatementContext ctx) {
        var while_context = ctx.whileStat();
        String startLabel = "while_start_" + labelCounter++;
        String endLabel = "while_end_" + labelCounter++;

        String condReg = allocateRegister();
        String condValue = visit(while_context.expr());
        whileInfo.while_statement_register_holder = condReg;

        whileInfo.while_statement_value = condValue;
        RISC_CODE.add("# holder for while cond register " + condReg);

        if (isNum(condValue)) {
            RISC_CODE.add(String.format("addi %s, x1, 0", whileInfo.while_statement_register_holder));
        } else {
            throw new RuntimeException("If condition must be numeric expression");
        }

        RISC_CODE.add(startLabel + ":");
        RISC_CODE.add("# while condition evaluation");
        RISC_CODE.add(String.format("blez %s, %s", whileInfo.while_statement_register_holder, endLabel));

        RISC_CODE.add("# while body");
        visit(while_context.block());

        // После выполнения тела цикла возвращаемся к проверке условия
        RISC_CODE.add("j " + startLabel);

        RISC_CODE.add(endLabel + ":");
        RISC_CODE.add("# end while");
        freeRegister(condReg);
        whileInfo.while_statement_register_holder = "";

        return "";
    }

    @Override
    public String visitCond_value(GrammarMinilangParser.Cond_valueContext ctx) {
        if (!isNum(whileInfo.while_statement_value)) {
            throw new RuntimeException("visitCond_value: while_statement_value must be number");
        }
        RISC_CODE.add("# return cond value " + whileInfo.while_statement_value);
        return whileInfo.while_statement_value;
    }

    @Override
    public String visitCond_value_expr(GrammarMinilangParser.Cond_value_exprContext ctx) {
        RISC_CODE.add("# evaluate cond for while");
        RISC_CODE.add("# " + ctx.expr().getText());
        RISC_CODE.add("# must take result from x1 register");
        var res = visit(ctx.expr());

        if (!isNum(res)) {
            throw new RuntimeException("visitCond_value_expr: while_statement_value must be number");
        }

        whileInfo.while_statement_value = res;
        RISC_CODE.add("# save resulted value expr into " + whileInfo.while_statement_register_holder);
        RISC_CODE.add(String.format("add %s, %s, x1", whileInfo.while_statement_register_holder, whileInfo.while_statement_register_holder));

        return res;
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
    public String visitMultiple_logic_block(GrammarMinilangParser.Multiple_logic_blockContext ctx) {
        int i = 1;
        for (GrammarMinilangParser.StatContext stat : ctx.stat()) {
            String statementResult = visit(stat);
            i++;
        }
        return "1";
    }

    @Override
    public String visitSingle_logic_block(GrammarMinilangParser.Single_logic_blockContext ctx) {
        visit(ctx.stat());
        return "";
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

        return String.valueOf(result ? 1 : 0);
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
            RISC_CODE.add("addi x1, zero, " + string_rep);
            return string_rep;
        }
        return string_rep;
    }

    @Override
    public String visitEquality(GrammarMinilangParser.EqualityContext ctx) {
        var exp1 = ctx.expr(0);
        var exp2 = ctx.expr(1);
        var operator = ctx.op;

        String value1 = visit(exp1);
        String value2 = visit(exp2);

        RISC_CODE.add("# equality operation " + operator.getText());

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
    public String visitPrintSmth(GrammarMinilangParser.PrintSmthContext ctx) {
        return super.visitPrintSmth(ctx);
    }

    @Override
    public String visitPrintString(GrammarMinilangParser.PrintStringContext ctx) {
        String str_to_print = ctx.STRING().getText();
        String id_in_data_sec = "str_" + Integer.toString(String_unique_id_for_decl);
        STRING_NAME_IN_DATA_SECTION.put(str_to_print, id_in_data_sec);
        String_unique_id_for_decl += 1;

        DATA_SECTION.add(String.format("%s:  .asciz %s ", id_in_data_sec, str_to_print));
        RISC_CODE.add(String.format("la x2, %s",id_in_data_sec));
        RISC_CODE.add("mv x3, zero");
        RISC_CODE.add(" # must put into x2 address of string");
        RISC_CODE.add(" # x3 - length counter, must be zero");
        RISC_CODE.add(" # x1 - resulted length will be here");

        RISC_CODE.add("strlen:");
        RISC_CODE.add("  lb x4, 0(x2)"); // Загружаем символ
        RISC_CODE.add("  beqz x4, end_strlen"); // Если нуль-терминатор
        RISC_CODE.add("  addi x2, x2, 1"); // Следующий символ
        RISC_CODE.add("  addi x3, x3, 1"); // Увеличиваем счетчик
        RISC_CODE.add("  j strlen");
        RISC_CODE.add("  end_strlen:");
        RISC_CODE.add("  addi x1, x3, 0");

        RISC_CODE.add("li a7, 64"); // Номер syscall (write)
        RISC_CODE.add("li a0, 1"); //  Файловый дескриптор (1 = stdout)
        RISC_CODE.add(String.format("la a1, %s",id_in_data_sec)); // Адрес строки
        RISC_CODE.add("addi x1, x1, 1"); // Учет null terminator в длинне строки
        RISC_CODE.add("addi a2, x1, 0"); // Длина строки.
        RISC_CODE.add("ecall");
        return str_to_print;
    }

    @Override
    public String visitPrintExpr(GrammarMinilangParser.PrintExprContext ctx) {
        String exprValue = visit(ctx.expr());

        RISC_CODE.add("# print expression result");

        if (!isNum(exprValue)) {
            throw new RuntimeException(String.format(
                    "visitPrintExpr: argument isn't a number: %s", exprValue));

        }
        //RISC CALL. USE a instead of x
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
    public String visitLeft_expr(GrammarMinilangParser.Left_exprContext ctx) {
        //Need to rewrite when become more than 1 option in grammar for left_expr.
        return super.visitLeft_expr(ctx);
    }

}
