package codesprinters.autojava;

public class Hex extends AbstractShape implements Shape{

	private double a;

	public Hex(double a) {
		this.a = a;
	}


	public String getSide() {
		return "" + a;
	}

	@Override
	public double getArea() {
		Triangle t =  new Triangle(a, a, a);
		return 6*t.getArea();
	}

}