package kh.lclass.api.run;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

import kh.lclass.api.KhCommonApi;
import kh.lclass.api.TestSingleton;

//import static kh.lclass.api.KhCommonApi.checkMenu;

public class TestApi {
	public void testDate() {

		Date now = new Date(1000L);
		// 대부분 deprecated 되어있음
//		System.out.println(when);

		// new Calendar()오류
		// Cannot instantiate the type Calendar
		// 원인1. abstract class 2. 생성자 접근제한자 protected
		// 해결1
		Calendar c = new GregorianCalendar();
		// 해결2- Singleton -디자인패턴 중 하나
		Calendar c2 = Calendar.getInstance();

		TestSingleton ts = TestSingleton.getInstance();
		System.out.println(ts.getA());
		ts.setA(50);
		System.out.println(ts.getA());

		TestSingleton ts2 = TestSingleton.getInstance();
		System.out.println(ts2.getA());
		ts2.setA(100);
		System.out.println(ts2.getA());
	}

	public void testWrapperDoWhile() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("메뉴 1-5 사이 선택해주세요.");
			int menu = 0;

			try {
				String menuStr = sc.nextLine();
				menu = Integer.parseInt(menuStr);

			} catch (NumberFormatException e) {
			}
			// NumberFormatException
			// 생략해도 됨.
//				e.printStackTrace();

			if (!KhCommonApi.checkMenu(1, 5, menu)) {
				System.out.println("1-5사이 선택해주세요.");
				continue;
			}

			// 정상 입력경우
			System.out.println("정상적으로 입력되어서... 다른 함수 호출함.");
			testString();
			System.out.println("동작 마침!!!");
			break;
		}

//		
//		while(true) {
//		System.out.println("메뉴 1-5 사이 선택해주세요.");
//		int menu = 0;
//		//try 문안에는 작성x
//		try {
//			System.out.println("1");
//			 menu = sc.nextInt();
//			 
//			 System.out.println("2");
//		}catch (InputMismatchException e) {
//			//InputMismatchException
//			sc.nextLine();
//		}
//		
//		
//		if(menu <1|| menu >5) {
//			//비정상적 경우
//			
//			System.out.println("1-5사이 선택해주세요.");
//			continue;
//			
//		}
//			
//			//정상 입력경우
//			System.out.println("정상적으로 입력되어서... 다른 함수 호출함.");
//			testString();
//			System.out.println("동작 마침!!!");
//			break;
//		}
//		
//		

//		while(true) {
//		System.out.println("메뉴 1-5 사이 선택해주세요.");
//		int menu = sc.nextInt();
//		
//		if(menu > 0 && menu <6) {
//			//정상입력경우
//			System.out.println("정상적으로 입력되어서... 다른 함수 호출함.");
//			testString();
//			System.out.println("동작 마침!!!");
//			break;
//		}else {
//			//비정상 입력경우
//			System.out.println("1-5사이 선택해주세요.");
//		}
//		}
//		System.out.println("testWrapperDoWhile 끝");
	}

	public void testString() {
		StringBuffer str1 = new StringBuffer("aaa");
		StringBuffer str2 = new StringBuffer();
		str2.append("12345");
		str2.insert(2, "abc");
		System.out.println(str2);
		System.out.println(str2.indexOf("bc"));
		StringBuilder str3 = new StringBuilder("bbb");
		str3.insert(1, "111");
		System.out.println(str3);

		Scanner sc = new Scanner(System.in);
		System.out.println("구분자를 입력해 주세요.");
		String token = sc.nextLine();
		System.out.println("내용을 입력해 주세요.");
		String content = sc.nextLine();

		String str = "AA|BB|CC";
		StringTokenizer st = new StringTokenizer(str, "|");
		System.out.println(st);
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		System.out.println(st);

		// 기본자료형==> String
		int i = 35;
		double d = 35.0;
		String s1 = String.valueOf(d);
		String s2 = Double.valueOf(d).toString();

		// String ==>기본자료형
		String s = "35";
		// NumberFormatException : For input string : "35.251"
		i = Integer.parseInt(s);
		System.out.println(i);

		System.out.println("======끝=====");

		int bnum1 = 10;
		int bum2 = 11;
		String bcontent2 = "aaaa";
		String bwriter1 = "aa";
		bwriter1 = "bb";

	}
}
