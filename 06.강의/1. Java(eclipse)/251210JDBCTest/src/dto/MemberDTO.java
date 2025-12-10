package dto;

public class MemberDTO {

	private String id;
	private String name;
	private int	age;
	private String joindate;
	
	public MemberDTO() {
		
	}

	public MemberDTO(String id, String name, int age, String joindate) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.joindate = joindate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", age=" + age + ", joindate=" + joindate + "]";
	}
	
}
