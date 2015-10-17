package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMany() {
		assertEquals(32, Calculator.add("1,2,3,4,5,8,9"));
	}

	@Test
	public void testNewLine() {
		assertEquals(32, Calculator.add("1,2,3\n4,5,8,9"));
	}

	@Test
	public void testDeli() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testNegativeOneNumber() {
		assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
	}

	

	@Test
	(expected = IllegalArgumentException.class)
		public void testNegativeNumbers() {
		assertEquals("Negatives not allowed: -1,-3", Calculator.add("-1,2,-3"));
	}

	

	@Test
	public void testBigNumbers() {
		assertEquals(3, Calculator.add("//;\n1;2;2000"));
	}

	@Test
	public void testBigNumbers2() {
		assertEquals(8, Calculator.add("//;\n1;2;2000;3033;5"));
	}

}
