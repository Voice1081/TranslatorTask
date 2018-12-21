public class JavaEntryPointTranslator implements ITranslator {
    public JavaEntryPointTranslator(){
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
        Token t = new Token(getName(), null, "public class Main\n" +
                "{\n" +
                "\tpublic static void main(String[] args)", null, "}");
        t.setChildren(source.getChildren());
        return t;
    }
}
