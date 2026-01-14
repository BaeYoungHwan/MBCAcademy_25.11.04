package com.mbc.pro.util;

public class Util {

	// 답글의 화살표(arrow)와 공백을 추가하는 함수
	public static String arrow(int depth){
		String rs = "<img src='./images/arrow1.png' width='20px' height='20px'/>";
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		
		String ts = "";
		for(int i = 0;i < depth; i++){
			ts += nbsp;
		}
		
		return depth==0 ? "":ts+rs;	
	}
	
	// title이 (너무)길 경우 ...으로 출력하는 함수
	public static String dot3(String title) {
		String str = "";
		
		if(title.length() >= 35) {
			str = title.substring(0, 35);
			str += "...";
		}else {
			str = title.trim();
		}
		
		return str;
	}
	
}







