package igorekpotworek.rpn.parser;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.util.Deque;

class Numeric extends Operation {

  @Override
  protected boolean isApplicable(String token) {
    return NumberUtils.isCreatable(token);
  }

  @Override
  protected void apply(Deque<BigDecimal> stack, String token) {
    stack.push(new BigDecimal(token));
  }
}
