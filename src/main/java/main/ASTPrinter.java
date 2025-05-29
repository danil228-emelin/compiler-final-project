package main;

import org.antlr.v4.runtime.tree.*;

public class ASTPrinter implements ParseTreeVisitor<Void> {
    private int indent = 0;

    @Override
    public Void visit(ParseTree tree) {
        return tree.accept(this);
    }

    @Override
    public Void visitChildren(RuleNode node) {
        String nodeName = node.getClass().getSimpleName().replace("Context", "");
        printIndent(nodeName + " [");
        indent++;

        for (int i = 0; i < node.getChildCount(); i++) {
            node.getChild(i).accept(this);
        }

        indent--;
        printIndent("]");
        return null;
    }

    @Override
    public Void visitTerminal(TerminalNode node) {
        printIndent("TERMINAL: " + node.getText());
        return null;
    }

    @Override
    public Void visitErrorNode(ErrorNode node) {
        printIndent("ERROR: " + node.getText());
        return null;
    }

    private void printIndent(String text) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println(text);
    }
}
