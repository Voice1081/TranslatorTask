public class PascalAssignmentTranslator implements ITranslator {
    private String name;
    public PascalAssignmentTranslator(){
        setName("assignment");
    }
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
        String[] parts = source.getValue().split(":=");
        String name = parts[0];
        String value = parts[1];
        String pseudocode = name + ", " + value;
        return new Token(getName(), pseudocode);
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        String[] parts = source.getValue().split(", ");
        String name = parts[0];
        String value = parts[1];
        String code = name + ":=" + value;
        return new Token(getName(), code);
    }
}
