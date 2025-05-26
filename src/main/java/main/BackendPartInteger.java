package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import static java.util.Map.entry;

public class BackendPartInteger extends GrammarMinilangBaseVisitor<Integer> {
    Map<String, Integer> memory = new HashMap<String, Integer>();

    Map<Integer, BiFunction<Integer, Integer, Integer>> BINARY_OPS = Map.ofEntries(
            entry(LabeledExprParser.MUL, (a, b) -> a * b),
            entry(LabeledExprParser.DIV, (a, b) -> a / b),
            entry(LabeledExprParser.ADD, Integer::sum),
            entry(LabeledExprParser.SUB, (a, b) -> a - b),
            entry(LabeledExprParser.GT, (a, b) -> (a > b) ? 1 : 0),
            entry(LabeledExprParser.LT, (a, b) -> (a < b) ? 1 : 0),
            entry(LabeledExprParser.GE, (a, b) -> (a >= b) ? 1 : 0),
            entry(LabeledExprParser.LE, (a, b) -> (a <= b) ? 1 : 0),
            entry(LabeledExprParser.EQ, (a, b) -> (Objects.equals(a, b)) ? 1 : 0),
            entry(LabeledExprParser.NE, (a, b) -> (!Objects.equals(a, b)) ? 1 : 0)

    );


    @Override
    public Integer visitPrintString(LabeledExprParser.PrintStringContext ctx) {
        return 0;
    }

    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        if (EvalVisitorString.IsKeyExistInMemoryString(id)) {
            System.out.printf("Variable %s already defined as String\n", id);
            return Integer.MAX_VALUE;
        }
        int value = visit(ctx.expr());
        memory.put(id, value);
        return value;
    }

    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());
        if (!value.equals( Integer.MAX_VALUE)) {
            System.out.println("EVI: "+ value);
        }
        return value;
    }


    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memory.containsKey(id)) {
            return memory.get(id);
        } else if (EvalVisitorString.IsKeyExistInMemoryString(id)) {
            return Integer.MAX_VALUE;

        }
        System.out.printf("EVI: variable %s doesn't exist return 0\n", id);
        return 0;
    }

    @Override
    public Integer visitParens(LabeledExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }


    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {

        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (EvalVisitorString.IsKeyExistInMemoryString(possible_var_left) || EvalVisitorString.IsKeyExistInMemoryString(possible_var_right) ) {
                return Integer.MAX_VALUE;
        }

        return BINARY_OPS.get(ctx.op.getType()).apply(left, right);
    }

    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (EvalVisitorString.IsKeyExistInMemoryString(possible_var_left) || EvalVisitorString.IsKeyExistInMemoryString(possible_var_right) ) {
            return Integer.MAX_VALUE;
        }

        return BINARY_OPS.get(ctx.op.getType()).apply(left, right);

    }

    @Override
    public Integer visitEquality(LabeledExprParser.EqualityContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (EvalVisitorString.IsKeyExistInMemoryString(possible_var_left) || EvalVisitorString.IsKeyExistInMemoryString(possible_var_right) ) {
            return Integer.MAX_VALUE;
        }

        return BINARY_OPS.get(ctx.op.getType()).apply(left, right);
    }

    @Override
    public Integer visitRelational(LabeledExprParser.RelationalContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));

        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (EvalVisitorString.IsKeyExistInMemoryString(possible_var_left) || EvalVisitorString.IsKeyExistInMemoryString(possible_var_right) ) {
            return Integer.MAX_VALUE;
        }

        return BINARY_OPS.get(ctx.op.getType()).apply(left, right);
    }

    @Override
    public Integer visitWhileStatement(LabeledExprParser.WhileStatementContext ctx) {

        while (visit(ctx.whileStat().expr()) > 0) {
            visit(ctx.whileStat().block());
        }
        return 0;
    }

    @Override
    public Integer visitIfStatement(LabeledExprParser.IfStatementContext ctx) {
        int condition = visit(ctx.ifStat().expr());

        if (condition != 0) {
            visit(ctx.ifStat().block(0));
        } else if (ctx.ifStat().block(1) != null) {
            visit(ctx.ifStat().block(1));
        }

        return 0;
    }


    @Override
    public Integer visitMultiple_logic_block(LabeledExprParser.Multiple_logic_blockContext ctx) {
        for (int i = 0; ; i++) {
            if (ctx.stat(i) != null) {
                visit(ctx.stat(i));
            } else {
                break;
            }
        }
        return 0;
    }

    @Override
    public Integer visitSingle_logic_block(LabeledExprParser.Single_logic_blockContext ctx) {
        visit(ctx.stat());
        return 0;
    }


}
