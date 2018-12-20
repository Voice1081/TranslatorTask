public class PascalCloseBracketReader extends IReadable {
    public PascalCloseBracketReader(){
        setType("open bracket");
    }
    @Override
    protected Token tryGetToken(String input) {
        if(input.startsWith("end;")) return new Token(getType(), "end;");
        return null;
    }
}