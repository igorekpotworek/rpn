package igorekpotworek.rpn;

import igorekpotworek.rpn.loaders.ExpressionLoader;
import igorekpotworek.rpn.loaders.ExpressionLoaderFactory;
import igorekpotworek.rpn.parser.RPNParser;
import igorekpotworek.rpn.parser.RPNParserFactory;
import igorekpotworek.rpn.writers.ResultWriter;
import igorekpotworek.rpn.writers.ResultWriterFactory;

import java.math.BigDecimal;

public class RPNServiceImpl implements RPNService {

  private final ResultWriter resultWriter;
  private final ExpressionLoader expressionLoader;
  private final RPNParser rpnParser;

  public RPNServiceImpl(ResultWriter resultWriter, ExpressionLoader expressionLoader) {
    this.resultWriter = resultWriter;
    this.expressionLoader = expressionLoader;
    rpnParser = RPNParserFactory.getInstance();
  }

  public static void main(String[] args) {
    ResultWriter resultWriter = ResultWriterFactory.getConsoleResultWriterInstance();
    ExpressionLoader expressionLoader =
        ExpressionLoaderFactory.getConsoleExpressionLoaderInstance();
    new RPNServiceImpl(resultWriter, expressionLoader).run();
  }

  @Override
  public void run() {
    String expression = expressionLoader.load();
    BigDecimal result = rpnParser.eval(expression);
    resultWriter.save(result);
  }
}
