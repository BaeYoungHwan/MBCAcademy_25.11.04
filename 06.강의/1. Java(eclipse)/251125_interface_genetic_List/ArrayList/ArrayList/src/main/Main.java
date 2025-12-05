package main;

import java.util.ArrayList;
import java.util.List;

import cls.HumanDto;

public class Main {
	public static void main(String[] args) {
		/*
			Collection: 수집
			
			List: 목록		-> 		interface
				  데이터의 관리는 유동적으로 할 수 있는 배열.
				  관리는 index number로 접근 및 관리한다
				  선형구조를 가진다	
				  O-O-O-O-O-O-O-	
			
			ArrayList		-> class		<- 99%
				  검색이 우수하다
				  
			LinkedList
				  실시간으로 추가/삭제가 되는 경우에 우수하다 
				  
			Vector			
		*/
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		// CRUD
		// (끝에)추가		[0][1][2] <- [3]
		list.add(111);
		
		Integer in = new Integer(222);
		list.add(in);
		
		list.add(new Integer(333));
		
		// list의 size
		System.out.println(list.size());
		
		// list에서 데이터를 산출
		Integer out = list.get(1);
		System.out.println(out);
		
		// list에서 모든 데이터를 출력
		for(int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Integer num : list) {
			System.out.println(num);
		}
		
		// (원하는 위치에)추가	[0][1] [2]  <- [3]
		Integer inum = 3000;
		list.add(2, inum);
		
		for(Integer num : list) {
			System.out.println(num);
		}
		
		
		// 삭제
		Integer removeData = list.remove(1);
		System.out.println("삭제된 데이터:" + removeData);
		for(Integer num : list) {
			System.out.println(num);
		}
		
		// 검색
		int index = list.indexOf(3000);	// wrapper class 만 가능
		System.out.println("index:" + index);
		
		index = -1;
		for(int i = 0;i < list.size(); i++) {
			Integer num = list.get(i);
			if(num == 3000) {
				index = i;
				break;
			}			
		}
		System.out.println("index:" + index);
		
		int len = 0;
		for(Integer n : list) {
			if(n == 3000) {
				break;
			}
			len++;
		}
		
				
		// 수정
		Integer newInt = 1000;
		list.set(0, newInt);
		
		for(Integer num : list) {
			System.out.println(num);
		}
		
		
		List<String> sList = new ArrayList<String>();
		
		// CRUD
		
		
		List<HumanDto> humanList = new ArrayList<HumanDto>();
		
		// CRUD		
		// 추가 3명
		HumanDto dto = new HumanDto("홍길동", 24, 172.1);
		humanList.add(dto);
		
		humanList.add(new HumanDto("성춘향", 16, 156.4));
		humanList.add(new HumanDto("임꺽정", 26, 181.5));
		humanList.add(new HumanDto("홍두께", 22, 167.9));
				
//		for (HumanDto h : humanList) {
//			System.out.println(h.toString());
//		}		
				
		// 원하는 위치에 추가 1명
		HumanDto human = new HumanDto("김수현", 23, 180.2);
		humanList.add(2, human);
		
		for(int i = 0;i < humanList.size(); i++) {
			HumanDto h = humanList.get(i);
			System.out.println("humanList[" + i + "] = " + h.toString());
		}
		
		// 삭제 (검색:이름) 1명
		int findIndex = -1;
		String name = "임꺽정";
		HumanDto removeDto = null;
		for(int i = 0;i < humanList.size(); i++) {
			HumanDto h = humanList.get(i);
			if(name.equals(h.getName())) {
				//findIndex = i;
				removeDto = h;
				break;
			}
		}
		
	//	if(findIndex != -1) {
		if(removeDto != null) {
			//humanList.remove(findIndex);		// index로 삭제
			humanList.remove(removeDto);		// Object로 삭제
		}	
		
		for(int i = 0;i < humanList.size(); i++) {
			HumanDto h = humanList.get(i);
			System.out.println("humanList[" + i + "] = " + h.toString());
		}
		
		// 검색 (검색:이름) 1명
		String findName = "성춘향";
		HumanDto findDto = null;
		for (HumanDto h : humanList) {
			if(findName.equals(h.getName())) {
				findDto = h;
				break;
			}			
		}
		
		if(findDto != null) {
			System.out.println(findDto.toString());
		}		
		
		// 수정 (검색:이름) -> height
		findName = "김수현";
		HumanDto modifyDto = null;
		for (HumanDto h : humanList) {
			if(findName.equals(h.getName())) {
				modifyDto = h;
				break;
			}
		}
		
		double height = 199.9;
		modifyDto.setHeight(height);
		
	//	humanList.set(2, modifyDto);
		
		for (HumanDto h : humanList) {
			System.out.println(h.toString());
		}
		
	}
}








