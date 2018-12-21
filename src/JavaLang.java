import java.util.HashMap;

public class JavaLang extends ILanguage {
    public JavaLang(){
        this.name = "java";
        Lexer l = new Lexer();
        l.register(new JavaAssignmentReader());
        l.register(new JavaCloseBracketReader());
        l.register(new JavaEntryPointReader());
        l.register(new JavaForReader());
        l.register(new JavaOpenBracketReader());
        l.register(new JavaPrintReader());
        l.register(new JavaVarReader());
        this.lexer = l;
        this.translators = new HashMap<>();
    }
}
