public class PascalOpenBracketReader extends IReadable {
    public PascalOpenBracketReader(){
        setType("open bracket");
    }
    @Override
    protected Token tryGetToken(String input) {
        if(input.startsWith("begin")) return new Token(getType(), "begin");
        return null;
    }
}