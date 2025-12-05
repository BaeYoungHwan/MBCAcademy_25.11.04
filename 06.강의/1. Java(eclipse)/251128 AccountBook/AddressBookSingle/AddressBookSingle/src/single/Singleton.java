package single;

import java.util.ArrayList;
import java.util.List;

import dto.AddressDto;

public class Singleton {
	
	// singleton 기본 선언
	private static Singleton st = null;
	public List<AddressDto> list = null;
	
	// 기본 list 생성
	private Singleton() {
		list = new ArrayList<AddressDto>();
	}
	
	//싱글턴의 맴버 변수에 값 받기. >> 주소 저장
	public static Singleton getInstance() {
		if(st == null) {
			st = new Singleton();
		}
		return st;
	}

}
