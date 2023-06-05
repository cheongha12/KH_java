package kh.lclass.oop.sample;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 주석은 일반적으로 녹색
	 * 이것은 파랑색
	 * java docs에 표시됨.
	 * 여기에 UID 생성날짜 ,누가,무엇때문에 작성하였는지를 남겨야 함. 
	 */
	private static final long serialVersionUID = 5261393220028539109L;
	
		
	
	
	protected String name; 
	private int age;
	private char gender;
	private String password;
	
	
	/*녹색*/
	/**파랑색 작성위치 여기*/
	
	//기본생성자
	public Person() { }
	//allArgumentsConstructor
		//매개인자
	public Person(String name,int age ,char gender) {
		this.name =name;
		this.age = age;
		this.gender =gender;
		
		
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	//getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
	
	
	
 
	
	
}
