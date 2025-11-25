package main;

public class Main {
	public static void main(String[] args) {
		/*
			Generic : template((자료)형태)
			
			자료형의 변수
			같은 소스코드에서 다양한 자료형을 사용하고 싶은 경우에 설정하는 요소		
		*/
		
		Box<Integer> box = new Box<Integer>(123);
		System.out.println(box.getTemp());
		
		Box<String> sBox = new Box<String>("Hello");
		System.out.println(sBox.getTemp());
		
		BoxMap<Integer, String> bMap = new BoxMap<Integer, String>(333, "성춘향");
		System.out.println(bMap.getKey());
		System.out.println(bMap.getValue());
		
		BoxMap<Double, String> dMap = new BoxMap<Double, String>(777.7, "이몽룡");
		System.out.println(dMap.getKey());
		System.out.println(dMap.getValue());
		
		
	}
}

class Box<T>{
	T temp;
	
	public Box(T temp) {
		this.temp = temp;
	}
	public T getTemp() {
		return temp;
	}
	public void setTemp(T temp) {
		this.temp = temp;
	}
}

class BoxMap<Key, Value>{
	
	Key key;
	Value value;
	
	public BoxMap(Key key, Value value) {
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
		
}











