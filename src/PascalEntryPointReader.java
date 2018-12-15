public class PascalEntryPointReader extends IReadable {
    public PascalEntryPointReader(){
        setType("entry point");
    }

    @Override
    protected Token tryGetToken(String input) {
        if(!input.startsWith("begin")) return null;
        int endPos = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.substring(i).startsWith("end.")){
                endPos = i;
                break;
            }
        }
        if(endPos == 0) return null;
        return new Token(getType(), input.substring(0, endPos+4), null,
                input.substring(5, endPos));
    }
}
