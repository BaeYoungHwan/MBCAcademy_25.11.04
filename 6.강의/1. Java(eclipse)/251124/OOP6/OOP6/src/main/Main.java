package main;

import cls.Animal;
import cls.Cat;
import cls.Cow;
import cls.Dog;

public class Main {
	public static void main(String[] args) {
		
		// cat 2마리 dog 3마리 cow 1마리
		// 정해지면 문제없음
		
		// animal -> 10마리
		Cat cat[] = new Cat[2];
		Dog dog[] = new Dog[3];
	//	Cow cow = new Cow();
		
		cat[0] = new Cat();
		cat[1] = new Cat();
		dog[0] = new Dog();
		dog[1] = new Dog();
		
		
		Animal ani[] = new Animal[5];		
		ani[0] = new Cat();
		ani[1] = new Cat();
		ani[2] = new Dog();
		ani[3] = new Dog();
		ani[4] = new Cow();
		
		for (Animal animal : ani) {
			animal.speech();
			
			if(animal instanceof Cat) {
				Cat c = (Cat)animal;
				c.catMethod();
			}
			else if(animal instanceof Dog) {
				((Dog)animal).dogMethod();
			}
			else if(animal instanceof Cow) {
				Cow c = (Cow)animal;
				c.cowMethod();
			}			
		}
		
		// instanceOf
	//	if(ani[0] instanceof Cat) {
	//		Cat c = (Cat)ani[0];	// cast변환
	//		c.catMethod();
	//	}
		
		
		String str = "Hello";
		Integer in = 123;
		Double dou = 123.4567;
		
		Object obj[] = new Object[3];
		obj[0] = new String("Hello");
		obj[1] = new Integer(123);
		obj[2] = new Double(123.4567);
				
		
	}
}










