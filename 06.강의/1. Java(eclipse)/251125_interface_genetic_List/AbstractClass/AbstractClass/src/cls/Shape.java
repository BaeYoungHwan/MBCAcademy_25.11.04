package cls;

public abstract class Shape {
	protected int x, y;

	public Shape() {
		this(10, 10);
	}
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract double calArea();
	
	
}





