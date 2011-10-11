package numerics;

public class NewtonRapsonMethod {

	/**
	 * Calculates an argument x such that f(x) = y.
	 * This is the same as solving the equation g(x) = 0, with g(x)=f(x)-y, 
	 * that is, finding a root of g(x), which can be found with the
	 * Newton-Rapson method.
	 * 
	 * @param f the function "f"
	 * @param df the first derivative of "f"
	 * @param y the "y" value
	 * @param x0 an initial guess for "x" (e.g., 0)
	 * @param maxError the maximum absolute error of the result
	 * @return the (approximate) "x" value
	 */

	public static double findArgument(Function f, Function df, double y, double x0, double maxError) {
		double x = x0;
		double error = 0.0;
		
		do {
			double nextX = x - (f.eval(x) - y) / df.eval(x);
			error = Math.abs(nextX - x); 
			x = nextX;
		} while (error > maxError);
			
		return x;			
	}
}
