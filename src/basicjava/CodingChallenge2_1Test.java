package basicjava;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class CodingChallenge2_1Test {
	String filename = "src/CodingChallenge2_1.java";

	/**
	Checks if the specified library is used anywhere in the code tested.  It checks
	for the word exactly.  If there is a variable name that contains the library name,
	this will result in a false positive.
	*/
	private boolean usesLibrary(String libraryName) {
		boolean usesLibrary = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesLibrary) {
				if (line.contains(libraryName)) {
					usesLibrary = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			fail("unable to open CodingChallenge2_1.java source file");
		} catch (IOException e) {
		}
		return usesLibrary;	
	}
	
	/**
		Checks if the coding construct is used in the class we're testing.  It expects the 
		construct to be preceded and followed by white space or parenthesis.
	*/
	private boolean usesConstruct(String constructName) {
		boolean usesConstruct = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesConstruct) {
				if (line.matches(".*\\s+if+[\\s+,(].*")) {
					usesConstruct = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			fail("unable to open CodingChallenge2_1.java source file");
		} catch (IOException e) {
		}
		return usesConstruct;	
	}
		
	
	@Test
	public void test_celsiusToFahrenheit_int0(){
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = 32.0;
		double actual = CodingChallenge2_1.celsiusToFahrenheit(0);
		assertEquals("Value of 0 Celsius.", expected, actual, 0.00001);
	}
	
	@Test
	public void test_celsiusToFahrenheit_double0(){
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = 32;
		int actual = CodingChallenge2_1.celsiusToFahrenheit(0.0);
		assertEquals("Value of 0 Celsius.", expected, actual);
	}
	
	@Test
	public void test_celsiusToFahrenheit_int1(){
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		double expected = 33.8;
		double actual = CodingChallenge2_1.celsiusToFahrenheit(1);
		assertEquals("Value of 1 Celsius.", expected, actual, 0.00001);
	}
	
	@Test
	public void test_celsiusToFahrenheit_double1(){
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		int expected = 33;
		int actual = CodingChallenge2_1.celsiusToFahrenheit(1.0);
		assertEquals("Value of 1 Celsius.", expected, actual);
	}
	
	@Test
	public void test_computePolynomial_0_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 28;
		double actual = CodingChallenge2_1.computePolynomial(0.0);
		
		assertEquals("Value of polynomial at 0.0", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_100_15() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 9857.7225;
		double actual = CodingChallenge2_1.computePolynomial(100.15);
		
		assertEquals("Value of polynomial at 100.15", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_negativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 31.990756;
		double actual = CodingChallenge2_1.computePolynomial(-1.234);
		
		assertEquals("Value of polynomial at -1.234", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_SmallNegativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 97555156.0;
		double actual = CodingChallenge2_1.computePolynomial(-9876.0);
		
		assertEquals("Value of polynomial at -9876.0", expected, actual, 0.00001);
	}

	@Test
	public void test_computePolynomial_LargeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		double expected = 97515652.0;
		double actual = CodingChallenge2_1.computePolynomial(9876.0);
		
		assertEquals("Value of polynomial at 9876.0", expected, actual, 0.00001);
	}

	@Test
	public void test_floorAfterMult_MultResultsInWholeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		long expected = 6;
		long actual = CodingChallenge2_1.floorAfterMult(2,3.0);
		
		assertEquals("Value of floor(2 * 3.0)", expected, actual);
	}

	@Test
	public void test_floorAfterMult_MultResultsInNegativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		long expected = -6;
		long actual = CodingChallenge2_1.floorAfterMult(2,-3.0);
		
		assertEquals("Value of floor(2 * -3.0)", expected, actual);
	}

	@Test
	public void test_floorAfterMult_MultResultsInDecimal() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		long expected = 6;
		long actual = CodingChallenge2_1.floorAfterMult(2,3.25);
		
		assertEquals("Value of floor(2 * 3.25)", expected, actual);
	}

	@Test
	public void test_floorAfterMult_checkIfCastAfterMult() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		long expected = 31;
		long actual = CodingChallenge2_1.floorAfterMult(5,6.2);
		
		assertEquals("Value of floor(5 * 6.2)", expected, actual);
	}

	@Test
	public void test_floorAfterMult_checkIfCastAfterMultLargeDiff() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		
		long expected = 34;
		long actual = CodingChallenge2_1.floorAfterMult(5,6.999);
		
		assertEquals("Value of floor(5 * 6.999)", expected, actual);
	}

	
	@Test
	public void test_addLastFourDigits_12345() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 14;
		int actual = CodingChallenge2_1.addLastFourDigits(12345);
		
		assertEquals("testing 12345", expected, actual);
	}
	
	@Test
	public void test_addLastFourDigits_00000() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 0;
		int actual = CodingChallenge2_1.addLastFourDigits(0);
		
		assertEquals("testing 00000", expected, actual);
	}

	@Test
	public void test_addLastFourDigits_76543() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 18 ;
		int actual = CodingChallenge2_1.addLastFourDigits(76543);
		
		assertEquals("testing 76543", expected, actual);
	}
	
	@Test
	public void test_addLastFourDigits_981000() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 1;
		int actual = CodingChallenge2_1.addLastFourDigits(981000);
		
		assertEquals("testing 981000", expected, actual);
	}

	@Test
	public void test_addLastFourDigitsDigits_71111() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use if statements.", usesConstruct("if"));
		assertFalse("Don't use while statements.", usesConstruct("while"));
		assertFalse("Don't use for statements.", usesConstruct("for"));
		
		
		int expected = 4;
		int actual = CodingChallenge2_1.addLastFourDigits(71111);
		
		assertEquals("testing 71111", expected, actual);
	}


}
