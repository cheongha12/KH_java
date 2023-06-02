package kh.lclass.collection;

import kh.lclass.oop.sample.Car;

public class Main {
	public static void main(String[] args) {
//		new TestCollection().testArrayList();
//		new TestCollection().testHaschMap();
//		new TestCollection().testStack();
		
		TestCollection tc= new TestCollection();
//		String str = tc.testGeneric(35.5);
		String str = tc.testGeneric(35.5,2);
		System.out.println(str);
		//str= tc.testGeneric("안녕",35);
		str= tc.testGeneric(35, "안녕");
		System.out.println(str);
		str= tc.testGeneric(22222222222222L, new Car(300));
		System.out.println(str);
		
		
		 
		
	}

}
