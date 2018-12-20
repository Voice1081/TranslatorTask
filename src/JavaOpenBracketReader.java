public class JavaOpenBracketReader extends IReadable {
    public JavaOpenBracketReader(){
        setType("open bracket");
    }
    @Override
    protected Token tryGetToken(String input) {
        if(input.charAt(0) == '{') return new Token(getType(), "{");
        return null;
    }
}
