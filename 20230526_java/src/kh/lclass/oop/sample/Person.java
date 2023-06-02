package kh.lclass.oop.sample;

public class Person {
	protected String name; //주민등록상 이름
	private int age;
	private char gender;
	
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
