package day10.thisex;

public class StudentMain {

	public static void main(String[] args) {
		Student1.printCount();
		
		Student1 std1 = new Student1(1,1,1,"JBC");
		Student1.printCount();
		
		Student1 std2 = new Student1(1,1,2,"JBJ");
		Student1.printCount();
		
		//std2.studentCount = 1;
		//System.out.println(std1.studentCount);
		std1.print();
		//Student1.print();//에러 발생. static이 print에는 안붙었기 때문
		std2.print();
		
		System.out.println(std1);
		System.out.println(std2);
	}

}

class Student1{
	private static int studentCount;
	private int grade, classnum, number;
	private String name;
	public Student1(int grade, int classnum, int number, String name) {
		// private는 건드릴수없기때문에 this를 이용하여 private의 정보를 수정
		this.grade = grade; //멤버변수 private와 매개변수 garde가 같기때문에 this를 써야함
		this.classnum = classnum;
		this.number = number;
		this.name = name;
		studentCount++;
	}
	public Student1() {
		//멤버변수와 이름이 같은 지역 변수를 만들수도 있다.(비추천)
		//int grade = 10;
		//this.grade = grade;
		this(1,1,1,""); // this를 이용하여 위의 항목들을 소환함
		name = "";
		/*
		grade = 1;// 기본생성자는 매개변수가 없기 때문에 this를 안써도됨(써도 무방)
		classnum = 1;
		number = 1;
		name = "";
		*/
	}
	
	
	
	//객체 메서드
	public void print() {
		System.out.println("============");
		System.out.println("grade : " + grade);//객체 변수 사용가능
		System.out.println("classNum : " + classnum);
		System.out.println("number :" + number);
		System.out.println("name :" + name);
		//클래스 변수 사용 가능
		//System.out.println("count : " + studentCount);
		//클래스 메서드 사용가능
		//printCount();
		
	}
	//클래스 메서드
	public static void printCount() {
		//클래스 변수 사용 가능
		System.out.println("Registered student count : " + studentCount);
		//객체 변수 사용 불가능
		//grade = 1;
		//객체 메서드 사용 불가능
		//print();
		//객체를 생성 후 호출해서 사용 가능
		Student1 std1 = new Student1();
		std1.name = "hong";
		std1.print();
	}
	
}
