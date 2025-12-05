package cls;

public class ChildClass extends ParentClass {

	public ChildClass() {
	//	super("홍길동");
		System.out.println("ChildClass ChildClass()");
	}
	
	public ChildClass(String name) {
		super(name);
		System.out.println("ChildClass ChildClass(String name)");
	}
	
	public void func() {
		System.out.println("func()는 부모클래스에서는 접근이 불가능하다");
	}
}
