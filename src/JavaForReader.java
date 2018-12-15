public class JavaForReader extends IReadable{
    public JavaForReader(){
        setType("for");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("for(")) return null;
        int firstBracketPos = -1;
        int lastBracketPos = 0;
        int counter = 0;
        String value = null;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ')') {
                value = input.substring(0, i + 1);
                break;
            }
        }
        if(value == null) return null;
        String body = input.substring(value.length());
        for(int i = 0; i < body.length(); i++){
            char ch = body.charAt(i);
            if(ch == '{'){
                if(firstBracketPos == -1)
                    firstBracketPos = i;
                counter += 1;
            }
            if(ch == '}'){
                counter -= 1;
                if(counter == 0) {
                    lastBracketPos = i;
                    break;
                }
            }
        }
        return new Token(getType(), input.substring(0, lastBracketPos+1), value,
                body.substring(firstBracketPos, lastBracketPos+1));
    }
}
