package main;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Compiler {
    public static final List<String> RISC_CODE = new ArrayList<>();
    private static final Map<String, String> MEMORY_STRING = new HashMap<>();
    private static final Map<String, Integer> MEMORY_INTEGER = new HashMap<>();

    /**
    private static void printTree(Tree tree, int indent) {
        String nodeName = tree.getClass().getSimpleName().replace("Context", "");
        if (nodeName.isEmpty()) nodeName = tree.getClass().getSimpleName();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|   ");
        }
        sb.append(nodeName).append(": ").append(tree.getText().replace("\n", "\\n"));
        System.out.println(sb.toString());

        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), indent + 1);
        }
    }
     **/

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GrammarMinilangLexer lexer = new GrammarMinilangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarMinilangParser parser = new GrammarMinilangParser(tokens);
        ParseTree tree = parser.prog();

        BackendPartInteger eval = new BackendPartInteger();
        BackendPartString evalVisitorString = new BackendPartString();
        evalVisitorString.visit(tree);
        eval.visit(tree);
    }
}
