package main;

import cls.Point3D;

public class Main {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(1, 2, 3);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1==p2?" + (p1 == p2));
		System.out.println("p1.equals(p2)?" + (p1.equals(p2)));
		
		Unit unit[] = new Unit[5];
		
		unit[0] = new Marine();
		unit[1] = new Tank();
		unit[2] = new Marine();
		unit[3] = new Dropship();
		unit[4] = new Tank();
		
		unit[0].move(100, 200);
		unit[1].move(350, 210);
		unit[2].move(190, 240);
		unit[3].move(300, 160);
		unit[4].move(500, 300);
		
		unit[0].stop();
		unit[1].stop();
		unit[2].stop();
		unit[3].stop();
		unit[4].stop();
		
	//	for(int i = 0;i < unit.length; i++) {
		for (Unit u : unit) {
	//		if(unit[i] instanceof Marine) {
			if(u instanceof Marine) {
				Marine m = (Marine)u;
				m.stimPack();
			}
			else if(u instanceof Tank) {
				Tank t = (Tank)u;
				t.changeMode();
			}
			else if(u instanceof Dropship) {
				Dropship d = (Dropship)u;
				d.load();
				d.unload();
			}
		}
				
		Robot[] arr = { 	
				new DanceRobot(), 
				new SingRobot(), 
				new DrawRobot()
		};
		
		for(int i=0; i< arr.length;i++) {
			action(arr[i]);
		}
	}
	
	static void action(Robot robot) {
		if(robot instanceof DanceRobot) {
			DanceRobot d = (DanceRobot)robot;
			d.dance();
		}
		else if(robot instanceof SingRobot) {
			SingRobot s = (SingRobot)robot;
			s.sing();
		}
		else if(robot instanceof DrawRobot) {
			DrawRobot d = (DrawRobot)robot;
			d.draw();
		}
	}
}

class Unit {
	int x, y; // 현재 위치

	void move(int x, int y) {
		System.out.println("x = " + x + " y = " + y);
	}

	void stop() {
		System.out.println("Stop!");
	}
}

class Marine extends Unit { // 보병
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ 
//	}
//
//	void stop() {
//		/* 현재 위치에 정지 */ 
//	}

	void stimPack() {
		/* 스팀팩을 사용한다. */
		System.out.println("스팀팩이다 받아라!");
	}
}

class Tank extends Unit { // 탱크
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ 
//	}
//
//	void stop() {
//		/* 현재 위치에 정지 */ 
//	}

	void changeMode() {
		/* 공격모드를 변환한다. */
		System.out.println("공격모드 전환");
	}
}

class Dropship extends Unit { // 수송선
//	int x, y; // 현재 위치
//
//	void move(int x, int y) {
//		/* 지정된 위치로 이동 */ 
//	}
//
//	void stop() {
//		/* 현재 위치에 정지 */ 
//	}

	void load() {
		/* 선택된 대상을 태운다. */
		System.out.println("모선에 타라");
	}

	void unload() {
		/* 선택된 대상을 내린다. */
		System.out.println("모선에서 내려라");
	}
}

class Robot {	
	
}

class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춥니다.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("노래를 합니다.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("그림을 그립니다.");
	}
}
