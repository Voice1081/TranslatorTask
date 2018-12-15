public class PascalForReader extends IReadable {
    public PascalForReader(){
        setType("for");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("for")) return null;
        int beginPos = -1;
        int endPos = 0;
        int counter = 0;
        String value = null;
        for(int i = 0; i < input.length()-3; i++) {
            String substr = input.substring(i, i+2);
            if(substr.equals("do")) {
                value = input.substring(0, i + 2);
                break;
            }
        }
        if(value == null) return null;
        String body = input.substring(value.length());
        for(int i = 0; i < body.length()-3; i++){
            String substr = body.substring(i);
            if(substr.startsWith("begin")){
                if(beginPos == -1)
                    beginPos = i;
                counter++;
            }
            if(substr.startsWith("end;"))
                counter--;
            if(beginPos != -1 && counter == 0){
                endPos = i;
                break;
            }
        }
        if(beginPos == -1 || endPos == 0 || beginPos >= endPos) return null;
        return new Token(getType(), input.substring(0, value.length()+endPos+4), value,
                body.substring(beginPos, endPos+4));
    }
}
