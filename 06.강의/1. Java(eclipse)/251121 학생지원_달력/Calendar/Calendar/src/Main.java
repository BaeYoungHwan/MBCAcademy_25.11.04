import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		/*
			Calendar	year month day
			Date		time
		*/
		
		//Calendar cal = new GregorianCalendar();
		
		Calendar cal = Calendar.getInstance();
		
		// 날짜 + 시간
		// getter
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;	// 0 ~ 11
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(year + "/" + month + "/" + day);
		System.out.println(hour + ":" + minute + ":" + second);
		
		// setter
		cal.set(Calendar.YEAR, 2025);
		cal.set(Calendar.MONTH, 12 - 1);	// 0 ~ 11
		cal.set(Calendar.DATE, 25);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;	// 0 ~ 11
		day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		
		// 요일
		int weekend = cal.get(Calendar.DAY_OF_WEEK); // 1 ~ 7  일 ~ 토
		System.out.println(weekend);
		
		String week = "";
		switch(weekend) {
			case 1:
				week = "일";
				break;
			case 2:
				week = "월";
				break;
			case 3:
				week = "화";
				break;
			case 4:
				week = "수";
				break;
			case 5:
				week = "목";
				break;
			case 6:
				week = "금";
				break;
			case 7:
				week = "토";
				break;
		}
		System.out.println(week + "요일입니다");
		
		// 지정한 달의 마지막 날짜	28 29 30 31
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		// 날짜 설정
		cal.set(Calendar.DATE, 1);
		
		// 위쪽의 빈칸
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		int up = (weekday - 1) % 7;
		System.out.println(up);
		
		// 밑의 빈칸
		cal.set(Calendar.DATE, lastday);
		weekday = cal.get(Calendar.DAY_OF_WEEK);
		
		int down = 7 - weekday;
		System.out.println(down);
		
		year = 2026;
		month = 5;
		
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, 1);
		
		int _startday = cal.get(Calendar.DAY_OF_WEEK);
		int _lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int _date = 1;
		
		System.out.println();
		System.out.println(year + "년 " + month + "월");
		
		System.out.println("======================================================");
		
		String week_day = "일월화수목금토";
		
		for (int i = 0; i < week_day.length(); i++) {
			char c = week_day.charAt(i);
			System.out.print(c + "\t");
		}
		System.out.println();
		
		System.out.println("======================================================");
		
		// 윗쪽 빈칸
		for (int i = 1; i < _startday; i++) {
			System.out.print("*" + "\t");
		}
		
		// 날짜
		for (int i = 0; i < _lastday; i++) {
			System.out.print(_date + "\t");
			
			if((_date + _startday - 1) % 7 == 0) {
				System.out.println();
			}
			
			_date++;
		}
		
		// 밑쪽 빈칸
		for (int i = 0; i < (7 - (_startday + lastday - 1) % 7); i++) {
			System.out.print("*" + "\t");
		}
		System.out.println();
		
		System.out.println("======================================================");
		
		
		
	}
}








