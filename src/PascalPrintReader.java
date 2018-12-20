public class PascalPrintReader extends IReadable {
    public PascalPrintReader(){
        setType("print");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("WriteLn(")) return null;
        String value = input.substring(8);
        int endIndex = 0;
        for(int i = 0; i < value.length() - 1; i++){
            String substr = value.substring(i, i+2);
            if (substr.equals(");")){
                endIndex = i+2;
                break;
            }
        }
        if(endIndex == 0) return null;
        return new Token(getType(), input.substring(8, 6+endIndex));
    }
}
