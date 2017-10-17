package junitdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test_Addition_In_Calculator_Class() {
		
		Calculator calculator = new Calculator();
		
		int five = calculator.add(2,3);
		int seven = calculator.add(3, 4);
		int fifty = calculator.multiply(5, 10);
		int sixty = calculator.multiply(6, 10);
		int one = calculator.subtract(2, 1);
		int oneHundred = calculator.subtract(200, 100);
		int ten = calculator.divide(200, 20);
		int eleven = calculator.divide(220, 20);
		int oneone = calculator.power(2, 0);
		int eigth = calculator.power(2, 3);
		int nine = calculator.power(3, 2);
		int factorial_zero = calculator.factorial(0); 
		int twentyfour = calculator.factorial(4); 
		int factorialSix = calculator.factorial(6);
		
		assertEquals("Should properly add two numbers.", 5, five);
		assertEquals("Should properly add two numbers.", 7, seven);
		assertEquals("Should properly multiply two numbers.", 50, fifty);
		assertEquals("Should properly multiply two numbers.", 60, sixty);
		assertEquals("Should properly subtract two numbers.", 1, one);
		assertEquals("Should properly subtract two numbers.", 100, oneHundred);
		assertEquals("Should properly divide two numbers.", 10, ten);
		assertEquals("Should properly divide two numbers.", 11, eleven);
		assertEquals("Should properly powered two numbers.", 1, oneone);
		assertEquals("Should properly powered two numbers.", 8, eigth);
		assertEquals("Should properly powered two numbers.", 9, nine);
		assertEquals("Should properly factorial number.", 1, factorial_zero);
		assertEquals("Should properly factorial number.", 24, twentyfour);
		assertEquals("Should properly factorial number.", 720, factorialSix);
		
		
	}

}
