package day16.homework.controller;

import java.util.Scanner;

import lombok.Data;

@Data
public class Controller {
	Scanner sc = new Scanner(System.in);
	private int wallet = 0;
	private int amount;
	private String drink[];
	
	
	
	public void run() {
		System.out.println("프로그램 시작!!");
		
			int user = -1;
			final int EXIT = 4;
			do {
				// 메뉴 출력
				menuPrint();
				//사용자 입력
				user = sc.nextInt();
				runMenu(user);
				//정보 출력
				
				
				
				
			}while(user != EXIT);
			System.out.println("프로그램 종료");
			
		}
	
	private void menuPrint() {
		System.out.println("==========");
		System.out.println("1. 금액투입");
		System.out.println("2. 메뉴선택");
		System.out.println("3. 제품입고");
		System.out.println("4. 프로그램 종료");
		System.out.println("=========");
	}
	
	private void runMenu(int user) {
		System.out.println("===========");
		switch(user) {
		case 1:
			money();
			break;
		case 2:
			System.out.println("메뉴선택");
			break;
		case 3:
			System.out.println("제품입고");
			break;
			default:
				
		}
	}
	private void money() {
		System.out.println("투입할 금액을 넣어주세요.");
		amount = sc.nextInt();
		wallet = wallet + amount;
		
		System.out.println("현재 금액 : " + wallet);
		
	}
	
	private void menuSellect() {
		System.out.println("1. 환타");
		System.out.println("2. 사이다");
		System.out.println("3. 콜라");
		
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			//Fanta
			break;
		case 2:
			//Sprite
			break;
		case 3:
			//Coke
			break;
			default:
			System.out.println("잘못된 입력");
		}
		
	}
	
	

}
