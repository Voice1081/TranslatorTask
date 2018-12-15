public class JavaEntryPointReader extends IReadable {
    public JavaEntryPointReader(){
        setType("entry point");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("public static void main(String[] args)")) return null;
        int firstBracketPos = -1;
        int lastBracketPos = 0;
        int counter = 0;
        String body = input.substring(39);
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
        if(firstBracketPos == -1 || lastBracketPos == 0 || firstBracketPos >= lastBracketPos) return null;
        return new Token(getType(), input.substring(0, lastBracketPos+1), "public static void main(String[] args)",
                body.substring(firstBracketPos, lastBracketPos+1));
    }
}
