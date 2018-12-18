public class JavaForTranslator implements ITranslator {

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
        String cycle = source.getValue();
        int startIndex = 0;
        int finishIndex = 0;
        for(int i = 0; i < cycle.length(); i++){
            char ch = cycle.charAt(i);
            if(ch == '(') startIndex = i;
            if(ch == ')') finishIndex = i;
            break;
        }
        String[] parts = cycle.substring(startIndex+1, finishIndex).split(";");
        String[] indexNameAndStartValue = parts[0].trim().substring(4).split("=");
        String indexName = indexNameAndStartValue[0].trim();
        String startValue = indexNameAndStartValue[1].trim();
        StringBuilder _finishValue = new StringBuilder();
        StringBuilder _operator = new StringBuilder();
        for(int i = 0; i < parts[1].length(); i++){
            char ch = cycle.charAt(i);
            if(ch == '<' || ch == '>' || ch == '=') _operator.append(ch);
            if(Character.isDigit(ch)) _finishValue.append(ch);
        }
        String finishValue = _finishValue.toString();
        String operator = _operator.toString();
        String increment;
        if(parts[3].contains("++"))
            increment = "++";
        else increment = "--";
        String pseudoCode = indexName + ", " + startValue + ", " + operator + ", " + finishValue + ", " + increment;
        Token tok = new Token(getName(), pseudoCode);
        tok.setChildren(source.getChildren());
        return tok;
    }

    @Override
    public Token translateFromPseudoCode(Token source) {
        String[] parts = source.getValue().split(", ");
        String code = "for(int " + parts[0] + "=" + parts[1] + ";" + parts[0] + parts[2] + parts[3] + ";" + parts[0] + parts[4] + ")";
        Token tok = new Token(getName(),code);
        tok.setChildren(source.getChildren());
        return tok;
    }
}
