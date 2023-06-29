package day22.practice.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day22.practice.vo.PhoneList;

public class Controller implements Program2{
	
	private Scanner sc = new Scanner(System.in);
	private final int Exit = 5;
	
	private ArrayList<PhoneList> list = new ArrayList<>();

	@Override
	public void printMenu() {
		System.out.println("===========");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 전화번호 삭제");
		System.out.println("5. 프로그램 종료");
		
	}

	@Override
	public void run() {
		int menu;
		do {
			try {
			printMenu();
			System.out.println("input number");
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("==========");
			}catch(InputMismatchException e) {
				menu = Exit-1; 
				sc.nextLine();
				System.out.println("Wriong Input!");
			}
			
			
			
			
		}while(menu != Exit);
		
		
	}

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			phoneNumberRegistration();
			break;
		case 2:
			modifyPhoneNumber();
			break;
		case 3:
			phoneNumberSearch();
			break;
		case 4:
			phoneNumberDeleat();
			break;
		case 5:
			break;
			default:
				System.out.println("wrong input");
		}
		
		
	}

	private void phoneNumberDeleat() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 이름을 입력 : ");
		String name = sc.nextLine();
		
		System.out.println("삭제할 번호 입력 :");
		sc.nextLine();
		int num = sc.nextInt();
		
		PhoneList phone = new PhoneList(name, num);
		int index = list.indexOf(phone);
		
		if(index == -1) {
			System.out.println("없는 이름");
			return;
		}
		if(list.remove(phone)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void phoneNumberSearch() {
		// TODO Auto-generated method stub
		
	}

	private void modifyPhoneNumber() {
		// 
		System.out.println("변경할 번호의 이름을 입력 : ");
		String name = sc.nextLine();
		
		PhoneList phone = new PhoneList(name, 0);
		int index = list.indexOf(phone);
		
		if(index == -1) {
			System.out.println("없는 이름");
			return;
		}
		sc.nextLine();
		System.out.println("바꿀 번호를 입력");
		int num = sc.nextInt();
		phone = new PhoneList(name, num);
		if(list.contains(phone)) {
			System.out.println("등록 실패");
			return;
		}
		list.get(index).update(name, num);
		
		
		
		
		
	}

	private void phoneNumberRegistration() {
		System.out.println("이름 입력 :");
		String name = sc.nextLine();
		System.out.println("번호 입력");
		sc.nextLine();
		int num = sc.nextInt();
		
		PhoneList phone = new PhoneList(name, num);
		if(!list.contains(phone)) {
			list.add(phone);
			System.out.println("등록 성공");
			return;
		}else {
			System.out.println("등록 실패");
		}
			
		
		
		
		
	}

}
