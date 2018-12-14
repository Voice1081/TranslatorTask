import java.util.*;

public abstract class ILanguage {
    private String name;
    private Lexer lexer;
    public Lexer getLexer() {
        return lexer;
    }
    private HashMap<String, ITranslator> translators;
    public String getName() {
        return name;
    }
    public void register(ITranslator translator){
        translators.put(translator.getName(), translator);
    }
    public ITranslator getTranslator(String type){
        return translators.get(type);
    }
}
