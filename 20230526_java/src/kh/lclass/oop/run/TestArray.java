package kh.lclass.oop.run;

import kh.lclass.oop.sample.Person;
import kh.lclass.oop.sample.Student;

public class TestArray {

	public static void main(String[] args) {
		
		Object obj1 = new Student();
		Object obj2 = new Person();
		Person p1 = new Student ();
		Student s1 = new Student();
		
		
		
		
		
		
		//방법1
		Person[] personArray2 = new Person[] {new Person(), new Person(), new Person()};
		//방법2
		Person[] personArray = new Person[22];
		
		
		//personArray[0].setAge(25);
		//NullPointerException 
		//원인: . 점 앞에 있는 변수 (객체 = 인스턴스)가 null상태  
		//즉 personArray[0]이 null 주소값을 가지고 있음
		//해결방법 : 변수 (객체= 인스턴스)에 new생성자();를 해줌 
		personArray[0] = new Person();
		personArray[0].setAge(25);
		
		for(int i =0; i<personArray.length; i++) {
			personArray[i] = new Person();
		}
		
//		personArray3[0] = new Person();
//		personArray3[0].setAge(25);
//		personArray3[0].setName("김소똥");
//		personArray3[0].setGender('여');
//		personArray3[0].name ="sss";
		
//		personArray3[1]= new Person("김개똥", 19, '남');
//		personArray3[2] =new Person("김말똥",22,'남');
		
//		System.out.println(personArray3[0].getName);
		
		System.out.println("===studentArr====");
		Student[] stdArray = new Student[3];
		for (int i = 0; i<stdArray.length; i++) {
			stdArray[i] = new Student();
			
		}
//		stdArray[0].setAge= (15);
//		stdArray[0].setName=("김영희");
		stdArray[0].setGender('여');
		stdArray[0].setScore(85);
		stdArray[0].setGrade(3);
		System.out.println(stdArray[0].getName());
		System.out.println(stdArray[0].getAge());
		System.out.println(stdArray[0].getGender());
		
		System.out.println(stdArray[0].toString());
		//Student [name = null, score = 0, grade =0,
		//to String()=Person [name =김영희,age = 15,gender= 여]
		
//		Student yh = new Student ("김영희",'여',20,1) {
//			@Override
//			public void setGrade("학년 지정함")
		
			}
//		}
	}
// }
