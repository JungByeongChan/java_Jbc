package day25.test.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day25.test.student.vo.Student;

public class Controller {
	

	private ArrayList<Student> list = new ArrayList<>();
	

	final private int Exit = 3;
	Scanner sc = new Scanner(System.in);
	

	public void run() {
		int user;
		do {
			runMenu();
			System.out.println("이용할 메뉴의 번호를 입력하시오 :");
			user = sc.nextInt();
			mainMenu(user);
			
		}while(user != Exit);
	}


	private void mainMenu(int user) {
		switch(user) {
			case 1:
				insertStudent();
				break;
			case 2:
				searchStudent();
				break;
			case 3:
				System.out.println("종료");
				break;
				
				
		}
	}


	private void searchStudent() {
		
		
			for(Student tmp2 : list) {
				System.out.println(tmp2.toString());
			}
		
			
		
		
		
	}


	private void insertStudent() {
		
		System.out.println("등록할 학번을 입력하시오");
		int grade = sc.nextInt();
		System.out.println("등록할 과를 입력하시오");
		sc.nextLine();
		String Subject = sc.nextLine();
		System.out.println("등록할 이름을 입력하시오");
		String name = sc.nextLine();
		
		
		Student tmp = new Student(grade, name, Subject);
		list.add(tmp);
		System.out.println("등록 완료");
		System.out.println(tmp);
		
	}


	private void runMenu() {
		System.out.println("============");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 확인");
		System.out.println("3. 종료");
		
	}
	
	
	
	
}
