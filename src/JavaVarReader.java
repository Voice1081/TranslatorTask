public class JavaVarReader extends IReadable {
    private String[] types;
    public JavaVarReader(){
        setType("var");
        types = new String[]{"int", "String", "double"};
    }

    @Override
    protected Token tryGetToken(String input) {
        String type = null;
        for(String t: types){
            if(input.startsWith(t)){
                type = t;
                break;
            }
        }
        if(type == null) return null;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ';') return new Token(getType(), input.substring(0, i+1));
        }
        return null;
    }

    public static void main(String[] args){
        JavaVarReader r = new JavaVarReader();
        System.out.println(r.tryGetToken("int a;rthrthrth").getText());
    }
}
