package igorekpotworek.rpn;

import igorekpotworek.rpn.exceptions.RPNFormatException;
import igorekpotworek.rpn.parser.RPNParser;
import igorekpotworek.rpn.parser.RPNParserFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RPNParserTest {

  private RPNParser rpnParser;

  @Before
  public void setUp() {
    rpnParser = RPNParserFactory.getInstance();
  }

  @Test
  public void testEvalIfCorrectResultIsReturnedWhenCorrectExpressionIsPassed() {
    // Given
    String expr = "3 4 2 + 1 5 - 2 3.6 + - + +";
    BigDecimal expectedResult = new BigDecimal("-0.6");

    // When
    BigDecimal result = rpnParser.eval(expr);

    // Then
    assertThat(result, is(expectedResult));
  }

  @Test(expected = RPNFormatException.class)
  public void testEvalIfExceptionIsThrownIfIncorrectNumberOfOperationsIsInExpression() {
    // Given
    String expr = "3 4 2 + 1 5 - 2 3.6 + - + + +";

    // When
    rpnParser.eval(expr);

    // Then throw
  }

  @Test(expected = RPNFormatException.class)
  public void testEvalIfExceptionIsThrownIfIncorrectNumberOfNumericsIsInExpression() {
    // Given
    String expr = "3 4 2 + 1 5 - 2 3.6 + - + + 3";

    // When
    rpnParser.eval(expr);

    // Then throw
  }

  @Test(expected = RPNFormatException.class)
  public void testEvalIfExceptionIsThrownIfInCorrectCharacterInExpression() {
    // Given
    String expr = "3 4 a";

    // When
    rpnParser.eval(expr);

    // Then throw
  }

  @Test(expected = RPNFormatException.class)
  public void testEvalIfExceptionIsThrownIfExpressionIsEmpty() {
    // Given
    String expr = "";

    // When
    rpnParser.eval(expr);

    // Then throw
  }

  @Test(expected = RPNFormatException.class)
  public void testEvalIfExceptionIsThrownIfExpressionIsNull() {
    // When
    rpnParser.eval(null);

    // Then throw
  }
}
