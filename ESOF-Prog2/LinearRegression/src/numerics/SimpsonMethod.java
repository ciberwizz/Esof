package numerics;

/**
 * Class that implements the Simpson method for numerical integration.
 * 
 * @author João Pascoal Faria
 * @version 2.0
 * @created 27-Set-2011
 * 
 */
public class SimpsonMethod {

	/**
	 * Calculates an approximate value of the integral of a given function, between
	 * the given lower and upper limits, within a specified maximum error, by the
	 * Simpson method.
	 * It uses an auxiliary method to compute successive approximate values for
	 * numbers of segments n, 2n, 4n, 8n, ... , starting from an internally selected
	 * number, until the absolute difference between the last two values computed is
	 * less or equal than the allowable error, and then returns the last computed
	 * value.
	 * 
	 * @pre lower <= upper
	 * @pre maxError > 0
	 * 
	 * @param func
	 * @param lower
	 * @param upper
	 * @param maxError
	 * 
	 * @return the approximate value of the integral
	 */
	public static double calcIntegral(Function func, double lower, double upper, double maxError){
		// work parameters
		int n = 10;  // number of segments, initially 10 (hard-coded)
		double g1;   // approximate integral value for n segments
		double g2;   // approximate integral value for 2*n segments
		
		if (lower > upper)
			throw new IllegalArgumentException("violates: lower <= upper");
		
		if (maxError <= 0.0)
			throw new IllegalArgumentException("violates: maxError > 0");		

		// Compute an approximate integral (g1) value with the previous method and n segments
		g1 = calcIntegralWithNumSegments(func, lower, upper, n);

		// Repeat until an acceptable approximation is found
		while(true) {
			g2 = calcIntegralWithNumSegments(func, lower, upper, 2*n);
		
			if (Math.abs(g2 - g1) <= maxError)
				return g2;
		
			g1 = g2;
			n *= 2;
		}
	}
	
	/**
	 * Auxiliary method.
	 * Calculates an approximate value of the integral of the function given, between
	 * the given lower and upper limits, using a specified number of segments, by the
	 * Simpson formula.
	 * 
	 * @pre upper >= lower
	 * @pre numSegments > 0 && numSegments % 2 == 0 
	 * 
	 * @param func 
	 * @param lower 
	 * @param upper
	 * @param numSegments
	 * 
	 * @return the approximate value of the integral
	 */
	private static double calcIntegralWithNumSegments(Function func, double lower, double upper, int numSegments){
		// Declare work parameters: width, oddSum, evenSum
		double width;
		double oddSum = 0.0, evenSum = 0.0;
		
		// Check the pre-conditions and throw an Exception if they are violated
		if ( ! (upper >= lower) )
			throw new IllegalArgumentException("violates: upper >= lower");		
		if ( ! (numSegments > 0 && numSegments % 2 == 0) )
			throw new IllegalArgumentException("violates: numSegments > 0 && numSegments % 2 == 0");
		
		// Compute the segment with
		width = (upper - lower) / numSegments;
		
		// Sum up the function values for odd segments (1, ..., numSegments - 1),
		// and compute oddSum
		for ( int i = 1; i <= numSegments - 1; i += 2)
			oddSum += func.eval(lower + i * width);
		
		// Sum up the function values for even segments (2, ..., numSegments - 2),
		// and compute evenSum
		for ( int i = 2; i <= numSegments - 2; i += 2)
			evenSum += func.eval(lower + i * width);
		
		// Compute and return the final result			
		return width / 3 * (func.eval(lower) + 4 * oddSum + 2 * evenSum + func.eval(upper)); 
	}
}