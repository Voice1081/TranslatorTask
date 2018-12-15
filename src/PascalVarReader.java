public class PascalVarReader extends IReadable {
    public PascalVarReader(){
        setType("var");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("var")) return null;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ';') return new Token(getType(), input.substring(0, i+1));
        }
        return null;
    }
}