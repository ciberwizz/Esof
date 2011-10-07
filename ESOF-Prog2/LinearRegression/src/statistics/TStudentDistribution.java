package statistics;

import numerics.Function;
import numerics.GammaFunction;
import numerics.SimpsonMethod;

public class TStudentDistribution implements Function {

	private int d;
	double gf3, gf4;
	public TStudentDistribution(int i) {
		this.d = i;
		gf3 = new GammaFunction().calcGammaFunction((this.d+1.0)/2.0);
		gf4 = new GammaFunction().calcGammaFunction(this.d/2.0);
		
	}

	public double calcProbabilityDensity(double x) {
		
		
		
		//return gf4;
		return (gf3/((Math.pow(d*Math.PI, 1.0/2.0)*gf4))*Math.pow(1.0+(x*x)/d, -(d+1.0)/2.0));	
	}

	public double calcPGivenX(double x) {
		// TODO Auto-generated method stub
		if (x==0)
			return 0.5;
		else
			if (x>0.0)
				return 0.5 + SimpsonMethod.calcIntegral(this,0.0 ,x, 0.5E-5);
			else
				return 0.5 - SimpsonMethod.calcIntegral(this,0.0 , x, 0.5E-5);
	}

	public double calcXGivenP(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double eval(double x) {
		// TODO Auto-generated method stub
		return calcProbabilityDensity(x);
	}
}
