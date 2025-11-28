package single;

import java.util.ArrayList;
import java.util.List;

import dto.AccountDTO;

public class Singleton {
	
	// singleton 기본 선언
	private static Singleton st = null;
	public List<AccountDTO> list = null;
	public int Amount; //현재 금액을 위한 변수
	
	// 기본 list 생성
	private Singleton() {
		list = new ArrayList<AccountDTO>();
	}
	
	//싱글턴의 맴버 변수에 값 받기. >> 주소 저장
	public static Singleton getInstance() {
		if(st == null) {
			st = new Singleton();
		}
		return st;
	}

}
