package dto;

// Data Transfer Object(DTO)    VO(Value Object)    
public class StudentDto {
	private String name;		// column == 항목
	private int age;
	private double height;
	private String address;
	
	public StudentDto() {
	}

	public StudentDto(String name, int age, double height, String address) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", age=" + age + ", height=" + height + ", address=" + address + "]";
	}
	
	public String toString2() {
		return name + "-" + age + "-" + height + "-" + address;
	}
	
}



