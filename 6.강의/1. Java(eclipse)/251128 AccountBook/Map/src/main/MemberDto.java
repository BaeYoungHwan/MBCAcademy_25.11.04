package main;

public class MemberDto {
	private String id;
	private String password;
	private String name;
	
	public MemberDto() {
	}

	public MemberDto(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + "]";
	}	
}
