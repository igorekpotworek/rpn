package igorekpotworek.rpn.parser;

import igorekpotworek.rpn.exceptions.RPNFormatException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RPNParserImpl implements RPNParser {

  private final Operation numeric;

  RPNParserImpl() {
    numeric = new Addition();
    Operation addition = new Numeric();
    Operation subtraction = new Subtraction();

    numeric.setSuccessor(addition);
    addition.setSuccessor(subtraction);
  }

  @Override
  public BigDecimal eval(String expr) {
    if (expr == null || StringUtils.isWhitespace(expr))
      throw new RPNFormatException("Empty RPN expression");

    Deque<BigDecimal> stack = new LinkedList<>();
    final String[] tokens = expr.split("\\s");
    Arrays.stream(tokens).forEach(t -> numeric.process(stack, t));

    if (stack.size() == 1) return stack.pop();
    else throw new RPNFormatException("Incorrect RPN expression");
  }
}
