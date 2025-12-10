package dto;

public class AddressBookDTO {
	// 이름, 나이, 전화번호, 주소, 메모
		private String id;
		private String name;
		private int age;
		private String phone;
		private String address;
		private String memo;
		
		public AddressBookDTO() {
		}

		public AddressBookDTO(String id, String name, int age, String phone, String address, String memo) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.phone = phone;
			this.address = address;
			this.memo = memo;
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

		public String getPhone() {
			return phone;
		}

		public String getAddress() {
			return address;
		}

		public String getMemo() {
			return memo;
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

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

		@Override
		public String toString() {
			return "AddressBookDTO [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address="
					+ address + ", memo=" + memo + "]";
		}

		
}
