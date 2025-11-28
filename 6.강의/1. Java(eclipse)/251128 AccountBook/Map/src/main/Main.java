package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		/*
			Collection
			
			Map: interface
			
			HashMap: 사전 
					 "apple":"사과"
					    (key:value)    == Json  
					 Tree 구조로 되어 있음
					 (index 로 접근하는 것이 아님!!!)
					 key 는 중복을 허용하지 않는다
					 
			TreeMap: HashMap + Sorting
			         HashMap 에 비해서 효율이 떨어진다 
		*/
		
	//	HashMap<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// CRUD
		// 추가
		map.put(111, "백십일");
		map.put(222, "이백이십이");
		map.put(new Integer(333), new String("삼백삼십삼"));
		
		// map의 크기
		System.out.println("map의 총수:" + map.size());
		
		// value를 취득
		String v = map.get(333);
		System.out.println(v);
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			// key
			Integer key = it.next();
			String value = map.get(key);
			
			System.out.println("key:" + key + " value:" + value);
		}
		
		// 검색
		// 있음/없음 <- key
		boolean b = map.containsKey(333);
		System.out.println(b);
		
		if(map.containsKey(333)) {
			String value = map.get(333);
			System.out.println(value);
		}
		
		// 수정
		String val = map.replace(333, "300 + 30 + 3");
		System.out.println("수정되기 전 값:" + val);
		
		// map.put(333, "333");
		
		it = map.keySet().iterator();
		while(it.hasNext()) {
			// key
			Integer key = it.next();
			String value = map.get(key);
			
			System.out.println("key:" + key + " value:" + value);
		}
		
		// 삭제
		val = map.remove(222);
		System.out.println("삭제된 값:" + val);
		
		it = map.keySet().iterator();
		while(it.hasNext()) {
			// key
			Integer key = it.next();
			String value = map.get(key);
			
			System.out.println("key:" + key + " value:" + value);
		}
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto("abc", "123", "홍길동"));
		list.add(new MemberDto("bcd", "234", "성춘향"));
		list.add(new MemberDto("cde", "345", "임꺽정"));
		
		Map<String, MemberDto> memMap = new HashMap<String, MemberDto>();
		
		for (MemberDto dto : list) {		
			memMap.put(dto.getId(), dto);
		}
		
		Iterator<String> it1 = memMap.keySet().iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			MemberDto dto = memMap.get(key);
			System.out.println(dto.toString());
		}
		
		String findId = "bcd";
		if(memMap.containsKey(findId)) {
			MemberDto dto = memMap.get(findId);
			System.out.println(dto.toString());
		}
		
		HashMap<String, String> hashMap = new HashMap<String, String>();		
		hashMap.put("apple", "사과");
		hashMap.put("pear", "배");
		hashMap.put("grape", "포도");
		hashMap.put("banana", "바나나");
		
		// HashMap -> TreeMap
		TreeMap<String, String> treeMap = new TreeMap<String, String>( hashMap );
		
		// 오름
	//	Iterator<String> it2 = treeMap.keySet().iterator();
		
		// 내림
		Iterator<String> it2 = treeMap.descendingKeySet().iterator();
		
		while(it2.hasNext()) {
			String key = it2.next();
			String value = treeMap.get(key);
			System.out.println("key:" + key + " value:" + value);
		}
		
		/*
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("이름", "홍길동");
		hMap.put("나이", 24);
		hMap.put("학생데이터", dto);
		*/
	}
}














