
package numerics;

public  class GammaFunction {

	/**
	 * Calculates the Gamma function for an argument x, 
	 * but only for cases where 2x is integer and is >= 1.  
	 * 
	 * @param x the argument of the Gamma function
	 * @return the value of the gamma function
	 */
	public static double calcGammaFunction(double x){
		if (x < 0.5)
			throw new IllegalArgumentException("violates: x >= 0.5");		
		else if (x == 0.5)
			return Math.sqrt(Math.PI);
		else if (x == 1.0)
			return 1.0;
		else
			return (x - 1) * calcGammaFunction(x - 1);
	}
}
