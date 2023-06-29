package day22.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import day22.practice.controller.Program;
import day22.practice.vo.Student;

public class StudentManager3 implements Program{
	private Scanner sc = new Scanner(System.in);
	private final int Exit = 4;
	
	

	private List<Student> list =Arrays.asList(
		new Student(1,1,1,"Hong"),
		new Student(1,1,2,"Ling"),
		new Student(2,1,1,"Park"),
		new Student(3,1,1,"Lee"),
		new Student(3,3,2,"Kim")
		
	);
	

@Override
public void printMunu() {
	System.out.println("1.학생 전체 출력");
	System.out.println("2.학생 학년 출력");
	System.out.println("3.학생 검색 출력");
	System.out.println("4.종료");
}

@Override
public void run() {
	


	int menu;
	
	do {
		printMunu();
		System.out.println("실행 메뉴 선택 :");
		menu = sc.nextInt();
		runMenu(menu);
		System.out.println("==========");
		
		
		
	}while(menu != Exit);	}

private void studentSearch(int grade,int classNum,int num) {
	// 
	for(Student tmp : list) {
	if(tmp.equals(new Student(grade, classNum, num, ""))) {
	System.out.println(tmp);
	}
	}
}

private void studentGrade(int grade) {
	// 
	for(Student tmp : list) {
		if(tmp.equals(tmp)) {
		System.out.println(tmp);
		}
		}
}

private void studentList() {
	for(Student tmp : list) {
	System.out.println(tmp);
	}
}

@Override
public void runMenu(int menu) {
	int grade , classNum, num;
	Stream<Student> stream = list.stream();
	switch(menu) {
	case 1:
		stream.forEach(sr->System.out.println(sr));
		break;
	case 2:
		//검색할 학년 입력
		System.out.println("grade : ");
		grade = sc.nextInt();
		//filter는 매개변수로 Predicate 인터페이스의 객체가 필요
		//Predicate를 구현한 익명클래스를 람다식으로 만든 후에 객체를 생성해서 전달
		stream.filter(sr->sr.getGrade()==grade).forEach(sr->System.out.println(sr));
		break;
	case 3:
		//검색할 학년, 반, 번호 입력
		System.out.println("grade : ");
		grade = sc.nextInt();
		System.out.println("classNum : ");
		classNum = sc.nextInt();
		System.out.println("num : ");
		num = sc.nextInt();
		stream.filter(sr->sr.equals(new Student(grade, classNum, num, null))).forEach(sr->System.out.println(sr));
		break;
	case 4:
		break;
		default:
			System.out.println("잘못된 입력");
	}
}


}
