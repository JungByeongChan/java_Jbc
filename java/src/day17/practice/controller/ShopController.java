package day17.practice.controller;

import java.util.Scanner;

import day17.interfaceex.RunInterface;
import day17.practice.servise.ShopService;
import day17.practice.servise.ShopServiceImp;
import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;
import lombok.Data;
@Data
public class ShopController implements RunInterface{
	
	private Scanner sc = new Scanner(System.in);
	private Product list[] = new Product[10];//제품리스트
	private Customer customerList[] = new Customer[10]; // 최대 10명의 고객 관리
	private int customerCount = 0; 
	private int count = 0;//저장된 제품 대수
	private Sales salesHistory[] = new Sales[100];
	private int salesCount;
	//판매 기록//몇 개 판매했는지가 아닌, 몇 번을 판매했는지
	private int totalPrice;
	
	
	private ShopService shopService = new ShopServiceImp();
	
	
	
	
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
		System.out.println("5. 고객 관리");
		System.out.println("6. 프로그램 종료");
		System.out.println("메뉴 선택");
		
	}
	
	private void runMenu(int user) {
		System.out.println("==========");
		switch(user) {
		
		case 1:
			//제품명 입력
			System.out.print("제품명 : ");
			sc.nextLine();
			String name = sc.nextLine();
			//제품 개수 입력
			System.out.print("수량 : ");
			int amount = sc.nextInt();
			//고객 정보 입력
			System.out.print("번호 : ");
			String phoneNumber = sc.next();
			
			
			int salesCount = shopService.sell(list, count,
					customerList, customerCount,
					salesHistory, this.salesCount, name, amount, phoneNumber );
			if(salesCount == -1) {
				System.out.println("제품 판매 실패!");
			}else {
				System.out.println("제품 판매 성공!");
				this.salesCount = salesCount;
			}
			break;
		case 2:
			//입고할 제품 정보를 입력받아 제품 객체를 생성
			Product product = inputStoreProduct();
			//제품 리스트와 제품 수를 주고, 입고된 제품을 주고, 제품 입고를 관리하라고 시킴
			//정수로 저장해야하는 이유는
			//새 제품이 입고된 경우 제품 리스트에 추가되고 제품수가 1 증가해야하기 때문
			count = shopService.store(list, count, product);
			//list;//바뀜 == 
			//count;//안바뀜

			break;
		case 3:
			//제품명을 입력
			System.out.println("제품명 : ");
			sc.nextLine();
			String search = sc.nextLine();
			//제품을 검색해서 출력
			shopService.printProdunt(list, count, search);
			

			break;
		case 4:

			shopService.printSales(salesHistory, this.salesCount);

			break;
		case 5:
			Customer customer = inputRegisterCustomer();
			
			int count = shopService.registerCustomer(customerList, customerCount,
					customer);
			if(count == -1) {
				System.out.println("고객 등록 실패");
			}else {
				System.out.println("고객 등록 성공");
				customerCount = count;
			}

		case 6:
			break;
		default:
		System.out.println("Wrong Input!");
		}
	}
	
	
	private Customer inputRegisterCustomer() {
		//고객 정보 입력
		System.out.println("등록할 고객의 이름과 번호를 적어주세요. Ex) 홍길동 010 12345678");
		sc.nextLine();
		String name = sc.next();
		String phoneNumber = sc.next();
		
		//return new Customer(name, phoneNumber); => 풀어쓰면 이하의2줄이나옴
		Customer customer = new Customer(name, phoneNumber);
		return customer;
		
		
	}
	

	private Product inputStoreProduct() {
		
		
		System.out.println("입고할 제품명을 입력해 주세요.");
		sc.nextLine();
		String name = sc.nextLine();
		
		
		System.out.println("입고할 제품의 수량을 입력해 주세요.");
		int amount = sc.nextInt();
		
		if(amount < 0) {
			System.out.println("입고 수량 오류!");
			return null;
		}
		
		int index = indexOf(name);
		
		
		if(index != -1) {
			Product product = new Product(list[index]);
			product.setAmount(amount);
			return product;
		
		}
		
		if(count == list.length) {
			System.out.println("제품 리스트 다참!");
			return null;
		}
		
		
		System.out.println("새 제품 등록");
		System.out.println("모델명 :");
		sc.nextLine();
		String modelName = sc.nextLine();
		
		
		System.out.println("가격 :");
		int price = sc.nextInt();
		
		System.out.println("분류 : ");
		String category = sc.next();
			
		Product product = new Product(name, modelName, price, amount, category);
		
		return product;
		
		
		
		
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
	
	
		
	
	
	
	private void SalesInquiry() {
		//매출 내역 출력
			for(int i =0; i<salesCount; i++) {
				salesHistory[i].print();
			}

			//누적 매출역 출력
			System.out.println("누적 매출액 : " + totalPrice);
	}
}
	
	
	
