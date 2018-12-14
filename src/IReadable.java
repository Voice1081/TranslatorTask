public abstract class IReadable {
    private String type;
    protected void setType(String type){this.type = type;}
    protected String getType(){return type;}
    protected abstract Token tryGetToken(String input);
}
