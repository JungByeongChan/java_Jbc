package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.vo.Student;

public class StudentManager2 implements Program {
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

	private void print(Predicate<Student> p){
		// 
		for(Student tmp : list) {
		if(p.test(tmp)) {
		System.out.println(tmp);
		}
		}
	}

	

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			print(s->true);
			break;
		case 2:
			//검색할 학년 입력
			System.out.println("grade : ");
			final int grade1 = sc.nextInt();
			final int fGrade = grade1;
			print(s->s.getGrade() == fGrade);
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.println("grade : ");
			final int grade2 = sc.nextInt();
			System.out.println("classNum : ");
			final int classNum2 = sc.nextInt();
			System.out.println("num : ");
			final int num2 = sc.nextInt();
			print(s->s.equals(new Student(grade2,classNum2,num2,"")));
			break;
		case 4:
			break;
			default:
				System.out.println("잘못된 입력");
		}
	}

}
