public class PascalCloseBracketTranslator implements ITranslator {
    public PascalCloseBracketTranslator(){
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
        return new Token(getName(), "}");
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        return new Token(getName(), "end;");
    }
}