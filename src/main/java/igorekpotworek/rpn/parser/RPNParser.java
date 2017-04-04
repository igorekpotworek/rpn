package igorekpotworek.rpn.parser;

import java.math.BigDecimal;

public interface RPNParser {
  BigDecimal eval(String expr);
}
