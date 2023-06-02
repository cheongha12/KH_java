package kh.lclass.test;

import java.util.Scanner;

public class TestExam {
	public static void main(String[] args) {
		new TestExam().printGugudan();
	}

	public void printGugudan() {
		
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		if( 2<=dan && dan<=9) {
			//구구단표현
			for(int su = 1; su<10 ;su++) {
				System.out.println(dan+"*"+su+"="+dan*su);
				
			}
		}
		else {
			System.out.println("2-9사이 정수를 입력해주세요");
		}	
		
		
	
	
	
	
	if(2>dan  || dan>9) {
		//dan 이 2-9 사이 정수가 아니라면 
}	else {
	
}
	//"2-9사이 정수를 입력해주세요"
	if(!(2<=dan && dan <=9)) {
		
	}else {
		
	}
	
	
}
}
