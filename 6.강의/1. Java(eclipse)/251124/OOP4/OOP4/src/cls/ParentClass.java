package cls;

public class ParentClass {
	private String name;

	public ParentClass() {
		System.out.println("ParentClass ParentClass()");
	}

	public ParentClass(String name) {
		System.out.println("ParentClass ParentClass(String name)");
		this.name = name;		
	}

	public String getName() {
		return name;
	}		
	
}
