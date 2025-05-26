package main;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

import static main.Compiler.*;

public class BackendPartString extends GrammarMinilangBaseVisitor<String> {


    public static boolean IsKeyExistInMemoryString(String key) {
        return MEMORY_STRING.containsKey(key);
    }

    private static String current_register = "";
    private final List<String> USED_REGISTER = new ArrayList<>();

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
            register = VARIABLE_REGISTER__MAP.get(variableName);
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
    public String visitBlank(GrammarMinilangParser.BlankContext ctx) {
        return super.visitBlank(ctx);
    }

    @Override
    public String visitComment(GrammarMinilangParser.CommentContext ctx) {
        return super.visitComment(ctx);
    }

    @Override
    public String visitMultipleComment(GrammarMinilangParser.MultipleCommentContext ctx) {
        return super.visitMultipleComment(ctx);
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
        } else if (type.equals("int")){
            MEMORY_INTEGER.put(newVariable, 0);
            String reg = allocateRegister();
            VARIABLE_REGISTER__MAP.put(newVariable,reg);
            RISC_CODE.add("li " + reg + ", 0" );
        }
        else {
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
    public String visitAssignSt(GrammarMinilangParser.AssignStContext ctx) {
        return super.visitAssignSt(ctx);
    }

    @Override
    public String visitParens(GrammarMinilangParser.ParensContext ctx) {
        return super.visitParens(ctx);
    }

    @Override
    public String visitMinValue(GrammarMinilangParser.MinValueContext ctx) {
        return super.visitMinValue(ctx);
    }

    @Override
    public String visitLogicalNot(GrammarMinilangParser.LogicalNotContext ctx) {
        return super.visitLogicalNot(ctx);
    }

    @Override
    public String visitLogicalAnd(GrammarMinilangParser.LogicalAndContext ctx) {
        return super.visitLogicalAnd(ctx);
    }

    @Override
    public String visitAddSub(GrammarMinilangParser.AddSubContext ctx) {
        return super.visitAddSub(ctx);
    }

    @Override
    public String visitRelational(GrammarMinilangParser.RelationalContext ctx) {
        return super.visitRelational(ctx);
    }

    @Override
    public String visitId(GrammarMinilangParser.IdContext ctx) {
        return super.visitId(ctx);
    }

    @Override
    public String visitLogicalOr(GrammarMinilangParser.LogicalOrContext ctx) {
        return super.visitLogicalOr(ctx);
    }

    @Override
    public String visitValue(GrammarMinilangParser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public String visitEquality(GrammarMinilangParser.EqualityContext ctx) {
        return super.visitEquality(ctx);
    }

    @Override
    public String visitMulDiv(GrammarMinilangParser.MulDivContext ctx) {
        return super.visitMulDiv(ctx);
    }

    @Override
    public String visitVariable_decl_id(GrammarMinilangParser.Variable_decl_idContext ctx) {
        return super.visitVariable_decl_id(ctx);
    }

    @Override
    public String visitPrintExpr(GrammarMinilangParser.PrintExprContext ctx) {
        return super.visitPrintExpr(ctx);
    }

    @Override
    public String visitPrintString(GrammarMinilangParser.PrintStringContext ctx) {
        return super.visitPrintString(ctx);
    }

    @Override
    public String visitType_basic(GrammarMinilangParser.Type_basicContext ctx) {
        return super.visitType_basic(ctx);
    }

    @Override
    public String visitLeft_expr(GrammarMinilangParser.Left_exprContext ctx) {
        return super.visitLeft_expr(ctx);
    }

}
