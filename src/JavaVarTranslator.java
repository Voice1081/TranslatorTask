public class JavaVarTranslator implements ITranslator {
    private String name;
    @Override
    public void setName(String name) {
        this.name = name;
    }
    public JavaVarTranslator(){
        setName("var");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Token translateToPseudoCode(Token source) {
        String name;
        String type;
        String value = "";
        String[] parts = source.getValue().split("=");
        if(parts.length != 0){
            value = parts[1].trim();
        }
        String[] typeAndName = source.getValue().split(" ");
        type = typeAndName[0];
        name = typeAndName[1];
        return new Token(getName(), type + ", " + name + ", " + value);
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        String[] parts = source.getValue().split(", ");
        String code = parts[0] + " " + parts[1];
        if(!parts[2].equals(""))
            code += " = " + parts[2];
        return new Token(getName(), code);
    }
}
