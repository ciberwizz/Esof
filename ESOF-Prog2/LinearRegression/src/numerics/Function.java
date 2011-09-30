package numerics;

/**
 * Interface to be implemented by objects that represent real functions
 * of real values. 
 * 
 * @author Jo�o Pascoal Faria
 * @version 2.0
 * @created 27-Sep-2011
 * 
 */
public interface Function {

	/**
	 * Calculates the value of the function for a given argument. 
	 * Must be implemented by any class that implement this interface.
	 * 
	 * @param x function argument
	 * @return the function value
	 */
	public abstract double eval(double x);

}