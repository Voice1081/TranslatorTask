public class PascalAssignmentReader extends IReadable {
    public PascalAssignmentReader(){
        setType("assignment");
    }

    @Override
    protected Token tryGetToken(String input) {
        StringBuilder _name = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(Character.isLetter(ch)) _name.append(ch);
            else break;
        }
        if(_name.length() == 0) return null;
        String name = _name.toString();
        String value = input.substring(name.length());
        if(!value.startsWith(":=")) return null;
        for(int i = 0; i < value.length(); i++){
            char ch = value.charAt(i);
            if(ch == ';') return new Token(getType(), input.substring(0, i+2));
        }
        return null;
    }
}
