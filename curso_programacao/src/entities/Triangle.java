package entities;

public class Triangle {

	public double a;
	public double b;
	public double c;
	
	public double area;

	public void calcArea() {
		double p = ( a + b + c) / 2.0;
		area = Math.sqrt( p * (p-a) * (p-b)* (p-c) );
	}
	
	public void setValue( double parA, double parB, double parC ) {
		a = parA;
		b = parB;
		c = parC;
	}

	public double getArea() {
		return area;
	}
}
