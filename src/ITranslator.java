public interface ITranslator {
    void setName(String name);
    String getName();
    Token translateToPseudoCode(Token source);
    Token translateFromPseudoCode(Token source);
}
