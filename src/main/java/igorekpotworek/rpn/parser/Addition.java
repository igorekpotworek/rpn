package igorekpotworek.rpn.parser;

import igorekpotworek.rpn.exceptions.RPNFormatException;

import java.math.BigDecimal;
import java.util.Deque;

class Addition extends Operation {

  @Override
  protected boolean isApplicable(String token) {
    return "+".equals(token);
  }

  @Override
  protected void apply(Deque<BigDecimal> stack, String token) {
    if (stack.size() < 2) throw new RPNFormatException("Incorrect RPN expression");

    BigDecimal secondOperand = stack.pop();
    BigDecimal firstOperand = stack.pop();
    stack.push(firstOperand.add(secondOperand));
  }
}
