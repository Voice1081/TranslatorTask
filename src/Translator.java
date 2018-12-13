import java.util.ArrayList;
import java.util.HashMap;

public class Translator{
    private HashMap<String, ILanguage> languages;

    public void register(String languageName, ILanguage language){
        languages.put(languageName, language);
    }

    public ArrayList<Token> translate(String langFrom, String langTo, String source){
        ArrayList<Token> pseudoCode = languages.get(langFrom).translateToPseudoCode(source);
        return languages.get(langTo).translateFromPseudoCode(pseudoCode);
    }
}
