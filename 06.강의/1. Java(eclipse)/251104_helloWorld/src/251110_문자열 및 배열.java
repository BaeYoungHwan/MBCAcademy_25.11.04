import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		/*
			String : 문자열. wrapper class
					 문자열 저장, 편집, 정보취득					 
		*/
		
		//char c = 'A';
		//char str[] = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'  };
		
		int i = 123;
		//Integer in = 123;
		//Integer in = new Integer(123);
		
		//String str = "안녕하세요";
		String str = new String("안녕하세요");
		
		// 문자열의 길이
		System.out.println(str.length());
		
		// 문자열 연결
		String str1 = "Hello";
		String str2 = "World";
		
		//String str3 = str1 + str2;
		String str3 = str1.concat(str2);		
		System.out.println(str3);
		
		// 문자열 비교
		// 같은 문자열인지? 아닌지?
		String str4 = "hello";
		String str5 = "hello";
		
		boolean b = str4.equals(str5);
		System.out.println("b = " + b);
		
		// 지정문자의 위치
		String str6 = "안녕하세요 반갑습니다 안녕하세요";
		
		int n = str6.indexOf("하");
		System.out.println("n:" + n);
		
		n = str6.lastIndexOf("하");
		System.out.println("n:" + n);
		
		// 문자열의 수정
		String str7 = "올해 '수능한파' 없고 맑아…수능일 아침 2∼11도·낮 14∼19도";
		String str8 = str7.replace("수능한파", "변경됨");
		System.out.println(str8);
		
		// 문자열 자르기
		/*
			split : token 을 이용해서 문자열을 자를 수 있다
			hello-my-world	'-' => token 
		
			홍길동-24-부산시	-> { name:"홍길동", age:24, address:"부산시" }	
			사민-6-울산시		-> .csv	  홍길동,24,부산시
			선우대형-33-강릉시 
		*/
		String str9 = "홍길동-24-부산시"; 
		String str10[] = str9.split("-");
		System.out.println(str10.length);
		System.out.println(Arrays.toString(str10));		
		System.out.println(str10[0]);
		
		// (범위)문자열자르기
		String str11 = "반갑습니다 건강하세요";
		String str12 = str11.substring(6, 8);
		System.out.println(str12);
		
		str12 = str11.substring(6);
		System.out.println(str12);
		
		// 대문자, 소문자로 변경
		String str13 = "abcDEF";
		String str14 = str13.toLowerCase();
		String str15 = str13.toUpperCase();
		System.out.println(str14);
		System.out.println(str15);
		
		// 문자열의 앞과 뒤에 공백을 제거하는 함수
		String str16 = "    i like iphone  ";
		String str17 = str16.trim();
		System.out.println(str17);
		
		// contains 탐색(있다, 없다)
		String str18 = "부산시 수영구";
		boolean b1 = str18.contains("수영");
		System.out.println("b1:" + b1);
		
		// 문자열의 위치에 있는 한개의 문자를 산출
		String str19 = "World";
		char c = str19.charAt(3);
		System.out.println(c);
	}

}




