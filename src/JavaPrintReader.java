public class JavaPrintReader extends IReadable {
    public JavaPrintReader(){
        setType("print");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("System.out.println(")) return null;
        String value = input.substring(19);
        int endIndex = 0;
        for(int i = 0; i < value.length() - 1; i++){
            String substr = value.substring(i, i+2);
            if (substr.equals(");")){
                endIndex = i+1;
                break;
            }
        }
        if(endIndex == 0) return null;
        return new Token(getType(), input.substring(19, 18+endIndex));
    }
}
