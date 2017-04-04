package igorekpotworek.rpn.loaders;

import java.util.Scanner;

public class ConsoleExpressionLoader implements ExpressionLoader {

  @Override
  public String load() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter RPN Expression with space as a token separator: ");
    return scanner.nextLine();
  }
}
