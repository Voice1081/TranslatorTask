public class JavaCloseBracketTranslator implements ITranslator {
    public JavaCloseBracketTranslator(){
        setName("close bracket");
    }
    private String name;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Token translateToPseudoCode(Token source) {
        return source;
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        return source;
    }
}