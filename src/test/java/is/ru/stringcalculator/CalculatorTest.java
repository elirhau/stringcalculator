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
		assertEquals(2, Calculator.add("2"));
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


	@Test(expected = RuntimeException.class)  
    public void testThrowExecptionForNegativeNumbers(){
    	try{
    		Calculator.add("2,-4,3,-5");
    	}
    	catch (RuntimeException ex){
    		
    		assertEquals("Negatives not allowed: -4,-5",ex.getMessage());
    		throw ex;
    	}
    }	

	@Test(expected = RuntimeException.class)  
    public void testThrowExecptionForNegativeNumbers2(){
    	try{
    		Calculator.add("-2,-4,3,-5");
    	}
    	catch (RuntimeException ex){
    		
    		assertEquals("Negatives not allowed: -2,-4,-5",ex.getMessage());
    		throw ex;
    	}
    }

	@Test
	public void testBigNumbers() {
		assertEquals(3, Calculator.add("//;\n1;2;2000"));
	}

	@Test
	public void testBigNumbers2() {
		assertEquals(8, Calculator.add("//;\n1;2;2000;3033;5"));
	}

	@Test
	public void teststar() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void teststar2() {
		assertEquals(15, Calculator.add("//[****]\n10****2****3"));
	}

	@Test
	public void testKata8() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void testKata9() {
		assertEquals(20, Calculator.add("//[**][%][..]\n1..10**2%3..4"));
	}


}
