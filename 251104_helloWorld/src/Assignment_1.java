
public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2025-11-05 첫번째 과제_01
		
		System.out.println("=========================================");
		System.out.println("|이름    나이   전화번호       주소		|");
		System.out.println("=========================================");
		System.out.println("|홍길동   20   010-111-2222 경기도		|");
		System.out.println("|일지매   18   02-123-4567  서울		|");
		System.out.println("=========================================");
		
		
		//2025-11-05 첫번째 과제_02
		System.out.println("=========================================");
		System.out.println("\\  이름     나이   전화번호       주소	\\");
		System.out.println("=========================================");
		System.out.println("\\ \"홍길동\"   20   010-111-2222 \'경기도\'	\\");
		System.out.println("\\ \"일지매\"   18   02-123-4567  \'서울\'	\\");
		System.out.println("=========================================");
		
		//2025-11-05 첫번째 과제_03
		String name;
		int age;
		boolean gender;
		String phone;
		double height;
		String address;
		
		System.out.println("===========================================================");
		System.out.println("\\name\tage\t man\tpone\theight\taddress\t\\");
		System.out.println("===========================================================");
		name = "홍길동";
		age = 20;
		gender = true;
		phone = "010-111-2222";
		height = 175.12;
		address = "경기도";
		System.out.printf("\\%s\t%d\t%b\t%s\t%.2f\t%s\t\\\n ", name, age, gender, phone, height, address);
		
		name = "일지매";
		age = 18;
		gender = true;
		phone = "02-123-4567";
		height = 180.01;
		address = "서울";		
		System.out.printf("\\%s\t%d\t%b\t%s\t%.2f\t%s\t\\\n ", name, age, gender, phone, height, address);
		
		name = "장옥정";
		age = 14;
		gender = false;
		phone = "02-345-7890";
		height = 155.78;
		address = "부산";
		System.out.printf("\\%s\t%d\t%b\t%s\t%.2f\t%s\t\\\n", name, age, gender, phone, height, address);
		
		System.out.println("===========================================================");
		
		
		//2025-11-05 첫번째 과제_04
		
		int x, y, z;
		
		x = 0;
		y = 1;
				
		z = x;
		x = y;
		y = z;
		
		System.out.printf("x의 값은 : %d\n", x );
		System.out.printf("y의 값은 : %d", y);
		//System.in.
		
		
		

	}

}
