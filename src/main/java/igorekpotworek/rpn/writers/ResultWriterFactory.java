package igorekpotworek.rpn.writers;

public class ResultWriterFactory {

  private ResultWriterFactory() {}

  public static ResultWriter getConsoleResultWriterInstance() {
    return new ConsoleResultWriter();
  }
}
