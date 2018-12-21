import java.util.HashMap;

public class PascalLang extends ILanguage {
    public PascalLang(){
        this.name = "pascal";
        Lexer l = new Lexer();
        l.register(new PascalAssignmentReader());
        l.register(new PascalCloseBracketReader());
        l.register(new PascalEntryPointReader());
        l.register(new PascalForReader());
        l.register(new PascalOpenBracketReader());
        l.register(new PascalPrintReader());
        l.register(new PascalVarReader());
        this.lexer = l;
        this.translators = new HashMap<>();
    }
}