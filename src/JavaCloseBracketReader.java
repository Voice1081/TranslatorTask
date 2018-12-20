public class JavaCloseBracketReader extends IReadable {
    public JavaCloseBracketReader(){
        setType("close bracket");
    }
    @Override
    protected Token tryGetToken(String input) {
        if(input.charAt(0) == '}') return new Token(getType(), "}");
        return null;
    }
}