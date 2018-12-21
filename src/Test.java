import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        JavaLang java = new JavaLang();
        java.register(new JavaAssignmentTranslator());
        java.register(new JavaCloseBracketTranslator());
        java.register(new JavaEntryPointTranslator());
        java.register(new JavaForTranslator());
        java.register(new JavaOpenBracketTranslator());
        java.register(new JavaPrintTranslator());
        java.register(new JavaVarTranslator());
        PascalLang pascal = new PascalLang();
        pascal.register(new PascalAssignmentTranslator());
        pascal.register(new PascalCloseBracketTranslator());
        pascal.register(new PascalEntryPointTranslator());
        pascal.register(new PascalForTranslator());
        pascal.register(new PascalOpenBracketTranslator());
        pascal.register(new PascalPrintTranslator());
        pascal.register(new PascalVarTranslator());
        Translator tr = new Translator();
        tr.register(java);
        tr.register(pascal);
        ArrayList<Token> tokens = tr.translate("pascal", "java", "begin\n" +
                "var a: Integer;\n" +
                "var i: Integer;\n" +
                "for i:=0 to 9 do\n" +
                "begin\n" +
                "a := a + 1;\n" +
                "end;\n" +
                "WriteLn(a);\n" +
                "end;\n" +
                "end.");
        System.out.println(tr.translate(tokens));
    }
}
