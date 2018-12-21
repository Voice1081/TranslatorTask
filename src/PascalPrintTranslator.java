public class PascalPrintTranslator implements ITranslator {
    public PascalPrintTranslator(){
        setName("print");
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
        return new Token(getName(), "WriteLn(" + source.getValue() + ");");
    }
}
