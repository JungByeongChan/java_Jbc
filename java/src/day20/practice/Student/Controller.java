package day20.practice.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20.collection.Student;
import day20.practice.vo.Vo;
import lombok.Data;


public class Controller implements Program{
	
	private Scanner sc = new Scanner(System.in);
	private int menu;
	private final int EXIT = 4; 
	
	
	private ArrayList<Vo> list = new ArrayList<>();
	

	public void run() {
		
		
		do {
			try {
			//메뉴 출력
			System.out.println(list);
			printMenu();
			menu = sc.nextInt();
			
			//메뉴 선택
			runMenu();
			}catch(InputMismatchException e) {
				menu = EXIT-1; //종료메뉴가 아닌 아무 메뉴를 추가(다시 입력하게끔)
				sc.nextLine();//앞에서 잘못 입력한 내용을 비워줌
				System.out.println("Wriong Input!");
				
			}
		}while(menu != EXIT);
		
	}
	

	@Override
	public void printMenu() {
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 삭제");
		System.out.println("3. 학생 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("==========");
	}

	@Override
	public void runMenu() {

		switch(menu) {
		case 1:
			addStudent();
			break;
		case 2:
			deleatStudent();
			break;
		case 3:
			collectionStudent();
			break;
		case 4:
			System.out.println("4. 프로그램 종료");
			break;
			default:
				System.out.println("Wrong input");
		}
	}
	
	public void addStudent() {
		//추가할 학생의 정보를 입력
		System.out.println("학년을 입력하세요 : ");
		int grade = sc.nextInt();
		System.out.println("반을 입력하세요 : ");
		int classNum = sc.nextInt();
		System.out.println("번호를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println("이름을 입력하세요 : ");
		sc.nextLine();
		String name = sc.nextLine();
		//입력한 정보를 이용하여 학생 객체를 생성
		Vo std = new Vo(grade, classNum, num, name);
		
				
		//학생 리스트에 추가
		//학생이 있는지 없는지 확인(학년, 반, 번호)해서 없으면 추가
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("등록 성공");
			return;
		}else 
		//성공했는지 실패했는지 메시지 출력
		System.out.println("등록 실패");
		
	}
	
	public void deleatStudent() {
		//삭제할 학생 정보를 입력(학년, 반, 번호)
		System.out.println("학년을 입력하세요 : ");
		int grade = sc.nextInt();
		System.out.println("반을 입력하세요 : ");
		int classNum = sc.nextInt();
		System.out.println("번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		//삭제할 학생 정보를 이용하여 학생 객체를 생성
		Vo tmp = new Vo(grade, classNum, num, null);
		
		//삭제를 시도해서 성공하면 성공했다고, 실패하면 실패했다고 알려줌
		if(list.remove(tmp)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}
	public void collectionStudent() {

		//수정할 학생의 정보를 입력(학년, 반, 번호)
		System.out.println("학년을 입력하세요 : ");
		int grade = sc.nextInt();
		System.out.println("반을 입력하세요 : ");
		int classNum = sc.nextInt();
		System.out.println("번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		//수정할 학생이 있는지 없는지 확인
		
		//학생 객체를 생성
		Vo tmp = new Vo(grade, classNum, num, null);
		int index = list.indexOf(tmp);
		
		
		//없으면 종료
		if(index == -1) {
			System.out.println("업데이트 실패");
			return;
		}
		
		//수정될 학생 정보를 입력(학년, 반, 번호, 이름)
		System.out.println("학년을 입력하세요 : ");
		grade = sc.nextInt();
		System.out.println("반을 입력하세요 : ");
		classNum = sc.nextInt();
		System.out.println("번호를 입력하세요 : ");
		num = sc.nextInt();
		System.out.println("이름을 입력하세요 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//학생 정보를 수정
		//수정될 학생 정보가 이미 있는 학생인지 확인
		//수정될 정보를 이용하여 학생 객체를 생성
		tmp = new Vo(grade, classNum, num, name);
		//학년, 반, 번호가 일치하는 학생이 있는지 확인 있으면 종료
		if(list.contains(tmp)) {
			System.out.println("업데이트 실패");
			return;
		}
		
		list.get(index).update(grade, classNum, num, name);
		
	}
	
	
	
	
	
}
