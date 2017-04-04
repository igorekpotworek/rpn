package igorekpotworek.rpn.parser;

public class RPNParserFactory {
  private RPNParserFactory() {}

  public static RPNParser getInstance() {
    return new RPNParserImpl();
  }
}
