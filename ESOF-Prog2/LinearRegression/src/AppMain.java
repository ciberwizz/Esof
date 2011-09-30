import Auxiliar.LinkedList;


public class AppMain {
	static LinkedList<Double> numeros = new LinkedList<Double>();
	static double B0, B1, r, xk, yk;
	
	/**
	 * Main function.
	 */
	public static void main(String[] args) {
		
		// Get number values
		//loadNumber(filename);
		
		// Calculate data
		GetData();
		
		// Print results
		PrintData();
	}
	
	
	/**
	 * Calculate results of Linear Regression coefficients and R correlation.
	 */
	private static void GetData(){
		xk = 386;
		
		LinearRegression rCoeficient = new LinearRegression(numeros);
		r = rCoeficient.CalcR();
		
		LinearRegression B01Coeficients = new LinearRegression(numeros);
		B0 = B01Coeficients.CalcB0();
		B1 = B01Coeficients.CalcB1();
		yk = B01Coeficients.CalcYk(xk);
	}
	
	private static void PrintData() {
		//Print B0
		System.out.println("Regression Parameter B0: ");
		System.out.println(B0);
		System.out.println();
		
		// Print B1
		System.out.println("Regression Parameter B1: ");
		System.out.println(B1);
		System.out.println();
		
		// Print R
		System.out.println("Regression Parameter R: ");
		System.out.println(r);
		
		// Print Xk
		System.out.println("yk parameter for xk = " + xk + ": ");
		System.out.println(yk);
		System.out.println();
		
	}
}
