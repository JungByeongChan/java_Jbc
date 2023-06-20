package day15.practice.shop.controller;

import java.util.Scanner;

import day15.practice.shop.vo.Product;

public class ShopManager {
	
	private Scanner sc = new Scanner(System.in);
	private Product list[] = new Product[10];//제품리스트
	private int count = 0;//저장된 제품 대수
	
	
	public void run() {
		System.out.println("프로그램 시작!!");
		
			int user = -1;
			final int EXIT = 6;
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
		System.out.println("=======");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 등록");
		System.out.println("6. 프로그램 종료");
		System.out.println("메뉴 선택");
		
	}
	
	private void runMenu(int user) {
		System.out.println("==========");
		switch(user) {
		
		case 1:
			System.out.println("Product sales");
		
			break;
		case 2:

			Receiving();

			break;
		case 3:

			Inquiry();

			break;
		case 4:

			System.out.println("Sales inquiry");

			break;
		case 5:

			System.out.println("Customer registration");

		case 6:
			break;
		default:
		System.out.println("Wrong Input!");
		}
	}
	
	

	private void Sales() {
		
		
	}
	private void Receiving() {
		//입고할 제품명 입력
		System.out.println("입고할 제품명을 입력해 주세요.");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입고할 제품 수량
		System.out.println("입고할 제품의 수량을 입력해 주세요.");
		int amount = sc.nextInt();
		
		if(amount < 0) {
			System.out.println("입고 수량 오류!");
			return;
		}
		//제품 리스트에서 입고할 제품명이 있는지 찾음
		//제품 배열에 있는 제품명과 입고할 제품명이 같은지를
		//확인해서 같으면 위치를 기억하고
		int index = indexOf(name);
		
		//있으면 입고할 제품 수량 만큼 해당 제품에 입고
		//위치가 0이상이면
		if(index != -1) {
			list[index].store(amount);
			System.out.println("입고완료!");
			return;
		
		}
		//없으면 제품 리스트에 제품 정보를 추가(입고할 수량도 함께)
		//위치가 -1이면
		//최대치로 등록되어 있으면
		if(count == list.length) {
			System.out.println("제품 리스트 다참!");
			return;
		}
		
		//모델명 입력
		System.out.println("새 제품 등록");
		System.out.println("모델명 :");
		sc.nextLine();
		String modelName = sc.nextLine();
		
		//가격을 입력
		System.out.println("가격 :");
		int price = sc.nextInt();
		//제품 리스트에 추가
		System.out.println("분류 : ");
		String category = sc.next();
			
		//없으면 제품 리스트에 제품 정보를 추가(입고할 수량도 함께)
		//위치가 -1이면
		list[count++] = new Product(name, modelName, price, amount, category);

		System.out.println("제품 추가 후 입고 완료!");
		
		
		
		
		
		
		/*
		int Tv = 0; int Radio = 0;
		int Aircon = 0; int total;
		
		total = Tv + Radio + Aircon;
		System.out.print("현재 보유 제품대수는 " + total + "이며, " + "Tv는" + Tv + "이고 ");
		System.out.println("라디오는" + Radio + " 이며" + "에어컨은" + Aircon + "입니다.");
		System.out.println("추가할 제품과 수령을 입력해주세요.");
		
		Homeappliances[] appliances = new Homeappliances[total];
		int count = 0;
		
		int add = sc.nextInt();
		
		for(int i = Tv ; i < add ; i++) {
			
			appliances[count++] = new TV();
		}
		*/
		
		
		
		
		
	}
	/**제품 리스트에 제품명과 일치하는 제품이 있으면 번지를, 없으면 -1을 알려주는 메서드
	 * 매개변수 : 제품명 => String name
	 * 리턴타입 : 제품이 있는 번지나 -1 => 정수 => int
	 * 메서드명 : indexOf
	 */
	public int indexOf(String name) {
		for(int i = 0; i < count ; i++) {
			if(list[i].getName().equals(name)) {
				return i;
			}
			
		}return -1;
	}
	
	
	private void Inquiry() {
		System.out.println("1. radio");
		System.out.println("2. Tv");
		System.out.println("3. Aircon");
		
		
		int user = sc.nextInt();
		Homeappliances(user);
		
	}
	private void Homeappliances(int user) {
		switch(user) {
		case 1:
			Radio();
			break;
		case 2:
			Tv();
			break;
		case 3:
			Aircon();
			break;
			
		}
	}
	
	private void Radio() {
		double frequency = 0;
		
		System.out.println(frequency);
	}
	private void Tv() {
		int channel = 1;
		System.out.println(channel);
	}
	private void Aircon() {
		double CurrentTemperature = 20;
		double desiredTemperature = 20;
		
		System.out.println(CurrentTemperature);
		System.out.println(desiredTemperature);
		
	}
	
	
	private void SalesInquiry() {
		
	}
	
	
	
	




	class Homeappliances{
		
	}
	class Radio extends Homeappliances{
		
		double frequency;
		
		
	}
	class TV extends Homeappliances{
		int channel;
	}
	class Airconditioner extends Homeappliances{
		double CurrentTemperature;//현재온도
		double desiredTemperature;//희망온도
	}

}
