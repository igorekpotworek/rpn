package igorekpotworek.rpn.parser;

import igorekpotworek.rpn.exceptions.RPNFormatException;

import java.math.BigDecimal;
import java.util.Deque;

abstract class Operation {

  private Operation successor;

  protected abstract boolean isApplicable(String token);

  protected abstract void apply(Deque<BigDecimal> stack, String token);

  void setSuccessor(Operation successor) {
    this.successor = successor;
  }

  void process(Deque<BigDecimal> stack, String exp) {
    if (isApplicable(exp)) apply(stack, exp);
    else if (successor != null) successor.process(stack, exp);
    else throw new RPNFormatException("Incorrect characters in RPN expression");
  }
}
