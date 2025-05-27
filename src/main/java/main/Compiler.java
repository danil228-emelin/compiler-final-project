package main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Compiler {
    public static final List<String> RISC_CODE = new ArrayList<>();
    public static final Map<String, String> MEMORY_STRING = new HashMap<>();
    public static final List<String> DATA_SECTION = new ArrayList<>();
    public static final Map<String, String> VARIABLE_REGISTER__MAP = new HashMap<>();

    public static final Map<String, String> MEMORY_INTEGER = new HashMap<>();

    /**
     * private static void printTree(Tree tree, int indent) {
     * String nodeName = tree.getClass().getSimpleName().replace("Context", "");
     * if (nodeName.isEmpty()) nodeName = tree.getClass().getSimpleName();
     * <p>
     * StringBuilder sb = new StringBuilder();
     * for (int i = 0; i < indent; i++) {
     * sb.append("|   ");
     * }
     * sb.append(nodeName).append(": ").append(tree.getText().replace("\n", "\\n"));
     * System.out.println(sb.toString());
     * <p>
     * for (int i = 0; i < tree.getChildCount(); i++) {
     * printTree(tree.getChild(i), indent + 1);
     * }
     * }
     **/

    public static void main(String[] args) throws Exception {
        String inputFile;
        if (args.length > 0) inputFile = args[0];
        else {
            inputFile = null;
        }

        InputStream is = System.in;
        if (inputFile != null) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GrammarMinilangLexer lexer = new GrammarMinilangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarMinilangParser parser = new GrammarMinilangParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e) {
                String errorMsg = String.format("Error in %s at line %d:%d - %s",
                        inputFile != null ? inputFile : "stdin",
                        line, charPositionInLine, msg);
                throw new RuntimeException(errorMsg);
            }
        });

        ParseTree tree = parser.prog();
        DATA_SECTION.add(".data");

        RISC_CODE.add(".global main");
        RISC_CODE.add(".text");
        RISC_CODE.add("main:");

        try {
            BackendPartString evalVisitorString = new BackendPartString();
            evalVisitorString.visit(tree);
            RISC_CODE.add("# exit");
            RISC_CODE.add("li a7, 93");
            RISC_CODE.add("ecall");
            DATA_SECTION.forEach(System.out::println);
            RISC_CODE.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("error in " +
                    (inputFile != null ? inputFile : "stdin") + ": " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Caused by: " + e.getCause().getMessage());
            }
            e.printStackTrace(System.err);
            System.exit(1);
        }


    }
}
