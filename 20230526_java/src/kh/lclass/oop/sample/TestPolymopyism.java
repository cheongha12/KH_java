package kh.lclass.oop.sample;

import java.util.ArrayList;

import java.util.List;

public class TestPolymopyism {
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		List<Car> carList = new ArrayList<Car>();//가장 흔하게 선언하는 방식
		
		
		
		
		
		
		
		
		
		//오류 new TestInterface();
//		TestInterface kh = new Kh();
//		((Kh)Kh).args
		
		TestInterface bit;
		TestInterface bit2;
		
		Kh Kh2 = new Kh();
//		kh2.KhSpecial();
		Kh2.method1();
		
		
		Driver ej = new DriverSub();
		ej.setMoney(10000);
		ej.buy(new Sonata());
		ej.buy(new Avante());
		
		Driver jh = new Driver2Sub();
		jh.setMoney(10000);
		jh.buy(new Sonata());
		jh.buy(new Avante());
	}
	
}
