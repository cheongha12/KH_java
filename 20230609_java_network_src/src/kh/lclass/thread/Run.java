package kh.lclass.thread;

public class Run {
	public static void main(String[] args) {
		
		
		
//			Thread ta= new ThreadAaa();
			Thread tb= new ThreadBbb();
			
			tb.start();
//run 일반 메소드 호출하듯 하면 Thread 동작 안함			
//				ta.run();
//				tb.run();
				for(int i=0; i<500; i++) {
					System.out.printf(i+"*");
		}
		
		System.out.println("******main끝**********");
	}
	

}
