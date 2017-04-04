package igorekpotworek.rpn.loaders;

public class ExpressionLoaderFactory {

  private ExpressionLoaderFactory() {}

  public static ExpressionLoader getConsoleExpressionLoaderInstance() {
    return new ConsoleExpressionLoader();
  }
}
