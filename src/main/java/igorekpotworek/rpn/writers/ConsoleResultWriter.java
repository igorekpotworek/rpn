package igorekpotworek.rpn.writers;

import java.math.BigDecimal;

public class ConsoleResultWriter implements ResultWriter {

  @Override
  public void save(BigDecimal result) {
    System.out.println("Result of RPN expression: " + result);
  }
}
