import java.util.HashMap;

public class PascalVarTranslator implements ITranslator{
    private String name;
    private HashMap<String, String> pascalTypes;
    private HashMap<String, String> pseudoCodeTypes;
    private void addType(String pascalType, String pseudoCodeType){
        pascalTypes.put(pseudoCodeType, pascalType);
        pseudoCodeTypes.put(pascalType, pseudoCodeType);
    }
    public void setName(String name) {
        this.name = name;
    }
    public PascalVarTranslator(){
        setName("var");
        pascalTypes = new HashMap<>();
        pseudoCodeTypes = new HashMap<>();
        addType("Integer", "int");
        addType("Real", "double");
        addType("String", "String");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Token translateToPseudoCode(Token source) {
        String name;
        String type;
        String[] typeAndName = source.getValue().substring(4).split(": ");
        type = pseudoCodeTypes.get(typeAndName[0]);
        name = typeAndName[1];
        return new Token(getName(), type + ", " + name);
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        String[] parts = source.getValue().split(", ");
        String type = parts[0];
        String name = parts[1];
        String code = "var " + name + ": " + pascalTypes.get(type);
        return new Token(getName(), code);
    }
}
