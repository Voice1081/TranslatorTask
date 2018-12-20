public class JavaOpenBracketTranslator implements ITranslator {
    public JavaOpenBracketTranslator(){
        setName("open bracket");
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
