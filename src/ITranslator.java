public interface ITranslator {
    void setName(String name);
    String getName();
    Token translateToPseudoCode(String source);
    Token translateFromPseudoCode(Token source);
}
