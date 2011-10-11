package statistics;

import numerics.Function;
import numerics.GammaFunction;
import numerics.LinearRegression;
import numerics.NewtonRapsonMethod;
import numerics.SimpsonMethod;
import Auxiliar.*;


public class TStudentDistribution implements Function {

	private int d;
	private double gf3, gf4;
	public boolean df;
	public TStudentDistribution(int i) {
		this.d = i;
		gf3 = new GammaFunction().calcGammaFunction((this.d+1.0)/2.0);
		gf4 = new GammaFunction().calcGammaFunction(this.d/2.0);
		df = true;
	}

	public double calcProbabilityDensity(double x) {

		return (gf3/((Math.pow(d*Math.PI, 1.0/2.0)*gf4))*Math.pow(1.0+(x*x)/d, -(d+1.0)/2.0));	
	}

	public double calcPGivenX(double x) {
		if (x==0)
			return 0.5;
		else
			if (x>0.0)
				return 0.5 + SimpsonMethod.calcIntegral(this,0.0 ,x, 0.5E-5);
			else
				return 0.5 - SimpsonMethod.calcIntegral(this,0.0 , x, 0.5E-5);
	}

	public double calcXGivenP(double p) {
		
		TStudentDistribution t = new TStudentDistribution(d);
		t.df = false;
			
		return truncateValue((new NewtonRapsonMethod()).findArgument(t, this, p, 0.0, 0.5E-5),5);
	}
	
	public double truncateValue(double value, int nCasas){
		int valueOfMul = 10;
		for (int i = 1; i < nCasas; i++) {
			valueOfMul *= 10;
		}
		return (double)Math.floor(value * valueOfMul) / valueOfMul;
	}
	
	
	public double calcUPI(double xk,double ran, LinkedList<Double> number_list){
		LinearRegression r = new LinearRegression(number_list);
		return r.CalcYk(xk) + calcRange(xk,ran,number_list);
	}
	
	public double calcLPI(double xk, double ran, LinkedList<Double> number_list){
		LinearRegression r = new LinearRegression(number_list);
		return r.CalcYk(xk) - calcRange(xk,ran,number_list);
	}
	
	public double calcRange(double xk, double ran, LinkedList<Double> number_list){
		
		double somatorio = 0.0;
		double xavg = 0.0;
		double raiz = 0.0;
		double tx = 0.0;
		number_list.reset();

		for(int i = 0; i<number_list.size() ; i++, number_list.nextNode())
			xavg += number_list.getNodeValue1();
		
		xavg = xavg/number_list.size();
		number_list.reset();
		
		//somatorio
		for(int i = 0; i<number_list.size() ; i++, number_list.nextNode())
			somatorio += Math.pow((number_list.getNodeValue1() - xavg),2);
		number_list.reset();

		
		raiz = 1.0 + 1.0/(double)number_list.size() + (Math.pow(xk -xavg, 2)/somatorio);
		raiz = Math.sqrt(raiz);
		
		tx = new TStudentDistribution(number_list.size()-2).calcXGivenP(0.5+(ran/2.0));
		
		
		
		return tx*calcDeviation(number_list)*raiz;
	}
	
	public double calcDeviation(LinkedList<Double> number_list) {
		
		LinearRegression lr = new LinearRegression(number_list);
		double b0 = lr.CalcB0();
		double b1 = lr.CalcB1();
		double somatorio = 0.0;
		number_list.reset();

		for(int i = 0; i<number_list.size() ; i++, number_list.nextNode())
			somatorio += Math.pow(number_list.getNodeValue2()-b0-b1*number_list.getNodeValue1(), 2);
		number_list.reset();

		
		return Math.sqrt((1/(double)number_list.size()-2) * somatorio);
		
	}

	@Override
	public double eval(double x) {
		if( df )
			return calcProbabilityDensity(x);
		else{
			df = true;
			double p = calcPGivenX(x);
			df = false;
			return p;
			
		}
	}
}
