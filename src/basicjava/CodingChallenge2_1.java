package basicjava;

/**
 * For this assignment, do the computations required in each of the static methods (functions) 
 * in this class.  
 * 
 * A video will be provided that shows how to complete the first two methods.  The remaining 
 * methods will be left to you to complete.
 */

public class CodingChallenge2_1 {
	
	/**
	 * Converts degrees Celsius to Fahrenheit to double precision.
	 * @param degreesCelsius the degrees Celsius to convert.
	 * @return degrees Fahrenheit equivalent to degress Celsius provided.
	 */
	public static double celsiusToFahrenheit(int degreesCelsius){
		double fahrenheit = degreesCelsius * 9.0/5 + 32;
		return fahrenheit;
	}
	
	/**
	 * Converts degrees Celsius to Fahrenheit rounded down to the nearest integer.
	 * @param degreesCelsius the degrees Celsius to convert as a double.
	 * @return the equivalent degrees Fahrenheit rounded down to the nearest integer.
	 */
	public static int celsiusToFahrenheit(double degreesCelsius){
		int fahrenheit = (int) (degreesCelsius *9/5 +32);
		return fahrenheit;		
	}
	
	/**
	 * Computes the value of the polynomial (3-x)^2 + 4(7+x) - 9.  
	 * @param x the value of x to use in the polynomial
	 * @return the value of the polynomial for provided value of x.
	 */
	public static double computePolynomial(double x){
		x = (x*x)-(2*x)+28;
		return x;
	}
	
	/**
	 * Multiplies the two parameters provided and returns the result rounded down to 
	 * the nearest integer.
	 * @param num1 the first number for the multiplication.
	 * @param num2 the second number for the multiplication.
	 * @return the result of the multiplications rounded down to the nearest integer.
	 */
	public static long floorAfterMult(int num1, double num2){
		double answer = num2 * num1;
		return (long) answer;
	}
	
	/**
	 * Takes the four least significant digits in the number provided as an argument, adds them
	 * together, and returns the result.  Example: when the argument num has value 2489634 
	 * then this function should return 4 + 3 + 6 + 9 = 20.
	 * @param num the integer that we use to compute the sum of the four least significant digits.
	 * @return the sum of the four least significant digits in num
	 */
	public static int addLastFourDigits(int num){
		// Hint: division and remainder allows you to get the right most digit and remove
		// the right most digit from a number.
		// Example: 997 % 10 = 7  (Remainder after division by 10.) Similarly, to remove the last
		// digit 997 / 10 = 99 (integer division result in the whole number that results from the
		// division.  
		int a = num % 10;
		num = num/10;
		int b = num % 10;
		num = num/10;
		int c = num % 10;
		num = num/10;
		int d = num % 10;
		num = num/10;
		int sum = a+b+c+d;
		return sum;
	}

	public static void main(String[] args) {
		double celsius = 20.0;
		System.out.println(celsius + " Celsius is -- " + celsiusToFahrenheit(celsius) + " Fahrenheit.");
	}

}
