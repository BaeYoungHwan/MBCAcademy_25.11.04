package cls;

public class Point3D {
	int x, y, z;

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point3D() {
		this(0, 0, 0);
	}

	@Override
	public boolean equals(Object obj) {
		Point3D pos = (Point3D)obj;
		
		if(x == pos.x && y == pos.y && z == pos.z) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {		
		return "[" + x + ", " + y + ", " + z + "]";
	}
	
	

//	public boolean equals(Object obj) {
//		/*
//		 * (1) 인스턴스변수x, y, z를 비교하도록 오버라이딩하시오.
//		 */
//	}
//
//	public String toString() {
//		/*
//		 * (2) 인스턴스변수x, y, z의 내용을 출력하도록오버라이딩하시오.
//		 */
//	}

}
