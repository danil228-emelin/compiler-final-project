package main;

import java.util.HashMap;
import java.util.Map;

public class BackendPartString extends GrammarMinilangBaseVisitor<String> {

    private static final Map<String, String> memoryString = new HashMap<String, String>();

    public static boolean IsKeyExistInMemoryString(String key){
        return memoryString.containsKey(key);
    }

    public Integer convertStringToInt(String s) {
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    @Override
    public String visitAddSub(LabeledExprParser.AddSubContext ctx) {
        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (memoryString.containsKey(possible_var_left) || memoryString.containsKey(possible_var_right) ) {
            return memoryString.get(possible_var_left)+memoryString.get(possible_var_right);

        }
        return "";
    }

    @Override
    public String visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        String value = visit(ctx.expr());
        if (value == null || value.isEmpty() || convertStringToInt(value)==Integer.MAX_VALUE) {return "";}
        System.out.println("EVS: "+ value);
        return "";
    }

    @Override
    public String visitIfStat(LabeledExprParser.IfStatContext ctx) {
        return "";
    }

    @Override
    public String visitPrintString(LabeledExprParser.PrintStringContext ctx) {
        String s = ctx.STRING().getText();
        System.out.printf(s);
        return s;
    }


    @Override
    public String visitAssignString(LabeledExprParser.AssignStringContext ctx) {
        String id = ctx.ID().getText();
        String value = ctx.STRING().getText();
        memoryString.put(id, value.substring(1,value.length()-1));
        return value;
    }

    @Override
    public String visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (memoryString.containsKey(possible_var_left) || memoryString.containsKey(possible_var_right) ) {
            System.out.println("Strings don't support multiplication and division");
        }
        return "";
    }

    @Override
    public String visitRelational(LabeledExprParser.RelationalContext ctx) {
        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (memoryString.containsKey(possible_var_left) || memoryString.containsKey(possible_var_right) ) {
            System.out.println("EVS: Strings don't support relational operations");
        }
        return "";
    }

    @Override
    public String visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if (memoryString.containsKey(id)) return memoryString.get(id);

        return "";
    }

    @Override
    public String visitEquality(LabeledExprParser.EqualityContext ctx) {
        String possible_var_left = ctx.getChild(0).getText();
        String possible_var_right = ctx.getChild(2).getText();

        if (memoryString.containsKey(possible_var_left) || memoryString.containsKey(possible_var_right) ) {
            return memoryString.get(possible_var_left).equals(memoryString.get(possible_var_right))?"1":"0";
        }
        return "";
    }
}
