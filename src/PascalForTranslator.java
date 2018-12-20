public class PascalForTranslator implements ITranslator {
    private String name;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Token translateToPseudoCode(Token source) {
        StringBuilder code = new StringBuilder(source.getValue().substring(4));
        StringBuilder name = new StringBuilder();
        StringBuilder startValue = new StringBuilder();
        StringBuilder finishValue = new StringBuilder();
        String increment = "";
        int startValuePos = 0;
        int finishValuePos = 0;
        for(int i = 0; i < code.length()-2; i++){
            char ch = code.charAt(i);
            if(Character.isLetter(ch)) name.append(ch);
            if(code.substring(i+1, i+3).equals(":="))
                startValuePos = i + 3;
            if(code.substring(i+1, i+7).equals("to") && startValuePos != 0) {
                finishValuePos = i + 7;
                increment = "++";
                break;
            }
            if(code.substring(i+1, i+3).equals("to") && startValuePos != 0) {
                finishValuePos = i + 3;
                increment = "--";
                break;
            }

        }
        String indexName = name.toString();
        for(int i = 0; i < code.length(); i++){
            char ch = code.charAt(i);
            if(Character.isDigit(ch)){
                if(i < finishValuePos)
                    startValue.append(ch);
                else finishValue.append(ch);
            }
        }
        String operator;
        if(increment.equals("++"))
            operator = "<=";
        else
            operator = ">=";
        String pseudoCode = indexName + ", " + startValue + ", " + operator + ", " + finishValue + ", " + increment;
        Token tok = new Token(getName(), pseudoCode);
        tok.setChildren(source.getChildren());
        return tok;


    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        String[] parts = source.getValue().split(", ");
        String operator = "";
        String finishValue = "";
        if(parts[2].equals("<")){
            finishValue = Integer.toString(Integer.parseInt(parts[3]) - 1);
            operator = " to ";
        }
        if(parts[2].equals(">")){
            finishValue = Integer.toString(Integer.parseInt(parts[3]) + 1);
            operator = " downto ";
        }
        if(parts[2].equals("<=")){
            finishValue = parts[3];
            operator = " to ";
        }
        if(parts[2].equals(">=")){
            finishValue = parts[3];
            operator = " downto ";
        }
        String code = "var" + parts[0] + ": Integer\n" + "for " + parts[0] + ":=" + parts[1] + operator + finishValue + " do";
        Token tok = new Token(getName(),code);
        tok.setChildren(source.getChildren());
        return tok;
    }
}
