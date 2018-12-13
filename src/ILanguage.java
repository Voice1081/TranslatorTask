import java.util.*;

public abstract class ILanguage {
    public String name;
    private HashMap<String, ITranslator> translators;
    public void register(ITranslator translator){
        translators.put(translator.getName(), translator);
    }

    public abstract ArrayList<Token> translateToPseudoCode(String source);

    public ArrayList<Token> translateFromPseudoCode(ArrayList<Token> source){
        ArrayList<Token> tokens = new ArrayList<>();
        for(Token token : source){
            Token newToken = translators.get(token.getType()).translateFromPseudoCode(token);
            tokens.add(newToken);
        }
        return tokens;

    }
}
