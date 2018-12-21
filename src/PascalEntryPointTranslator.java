public class PascalEntryPointTranslator implements ITranslator {
    public PascalEntryPointTranslator(){
        setName("entry point");
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
        Token t = new Token(getName(), null, "", null, "\nend.");
        t.setChildren(source.getChildren());
        return t;
    }
}