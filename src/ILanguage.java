import java.util.*;

public abstract class ILanguage {
    protected String name;
    protected Lexer lexer;
    public Lexer getLexer() {
        return lexer;
    }
    protected HashMap<String, ITranslator> translators;
    public String getName() {
        return name;
    }
    public void register(ITranslator translator){
        translators.put(translator.getName(), translator);
    }
    public ITranslator getTranslator(String type){
        return translators.get(type);
    }
    protected IReadable EntryPointReader;

}
