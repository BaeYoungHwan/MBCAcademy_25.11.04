package cls;

public class Circle extends Shape {
	
	double r;
	
	public Circle() {
	}
	
	public Circle(double r, int x, int y) {
		super(x, y);
		this.r = r;
	}

	@Override
	public double calArea() {		
		return (r * r * Math.PI);
	}
}



