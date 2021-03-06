import java.util.ArrayList;
import java.util.HashMap;

public class Translator {
    public Translator(){
        this.languages = new HashMap<>();
    }
    private HashMap<String, ILanguage> languages;

    public void register(ILanguage language) {
        languages.put(language.getName(), language);
    }

    private ILanguage getLanguage(String name) {
        return languages.get(name);
    }

    private ArrayList<Token> translateToPseudoCode(ILanguage key, ArrayList<Token> tokens) {
        ArrayList<Token> pseudoCode = new ArrayList<>();
        for (Token t : tokens) {
            ITranslator tr = key.getTranslator(t.getType());
            Token newToken = tr.translateToPseudoCode(t);
            if (t.getChildren() != null)
                newToken.setChildren(translateToPseudoCode(key, t.getChildren()));
            pseudoCode.add(newToken);
        }
        return pseudoCode;
    }

    private ArrayList<Token> translateFromPseudoCode(ILanguage dst, ArrayList<Token> pseudoCode) {
        ArrayList<Token> dstCode = new ArrayList<>();
        for (Token t : pseudoCode) {
            ITranslator tr = dst.getTranslator(t.getType());
            Token newToken = tr.translateFromPseudoCode(t);
            if (t.getChildren() != null)
                newToken.setChildren(translateFromPseudoCode(dst, t.getChildren()));
            dstCode.add(newToken);
        }
        return dstCode;
    }

    private ArrayList<Token> translate(ILanguage key, ILanguage dst, ArrayList < Token > tokens){
        ArrayList<Token> pseudoCode = translateToPseudoCode(key, tokens);
        return translateFromPseudoCode(dst, pseudoCode);
    }

    public ArrayList<Token> translate(String langFrom, String langTo, String source){
        ILanguage key = getLanguage(langFrom);
        ILanguage dst = getLanguage(langTo);
        ArrayList<Token> tokens = getTokens(key, source);
        return translate(key, dst, tokens);
    }

    public String translate(ArrayList<Token> tokens){
        StringBuilder text = new StringBuilder();
        for(Token t : tokens)
            text.append(t.toString());
        return text.toString();
    }

    private ArrayList<Token> getTokens(ILanguage key, String source){
        ArrayList<Token> tokens = key.getLexer().tokenize(source);
        ArrayList<Token> entryPoint = new ArrayList<>();
        for(Token t : tokens) {
            if (t.getType().equals("entry point"))
                entryPoint.add(t);
        }
        return entryPoint;
    }

}
