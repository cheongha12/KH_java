package kh.lclass.oop.sample;

public class Student extends Person{
	private String name;    //학생증용이름
	private int age;
	private char gender;
	private int score;
	private int grade;
	private  final int maxCount = 10;
	public Student() {
		//super(); //Person()
		super("김말똥",22,'남');
	}
	
	
	public Student (String name,char gender, int age) {
		super(name,age,gender);
		this.name =name;
		this.age = age;
		
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public String getName() {
		return this.name;
		
	
	}
	@Override 
	//Overriding 재정의 - 
	//성립조건 : 
	//상속한 클래스의 메소드와
	//동일한 메소드명
	//매개변수 자료형 , 개수 동일
	//리턴타입 동일
	//단 접근제한자는  달라도 됨. - 부모메소드의 접근제한자보다 넓은 범위 접근제한자를 사용해야함 
	public int getAge() {
		return super.getAge()+1 ; 
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
