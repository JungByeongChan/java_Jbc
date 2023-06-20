package day15.practice;

import java.util.Scanner;


public class ShopEx {

	public static void main(String[] args) {
		/*
		 * 가전제품(tv, 라디오, 에어컨)을 관리하는 프로그램을 작성하시오.
		 * 
		 * 메뉴
		 * 1. 제품판매 : 어떤 고객이 어떤 제품을 구매했는지 관리
		 * 2. 제품입고 : 새 제품이 추가됨, 어떤 제품이 몇개 추가됐는지 관리
		 * 3. 제품 조회 : 제품 정보 저회, 제품명으로 제품을 조회
		 * 4. 매출조회 : 판매된 제품 매출 조회. 누적 매출
		 * 5. 고객등록 : 고객을 추가하여 고객을 관리
		 * 6. 프로그램 종료
		 */
		Scanner sc = new Scanner(System.in);
		
		int menu = -1;
		do {
			// 메뉴 출력
			Menu.menuPrint();
			
			//사용자 입력
			System.out.println("메뉴 입력 :");
			int user = sc.nextInt();
			Menu.runMenu(user);
			//정보 출력
			
			
			
			
		}while(menu != 5);
		
		
		sc.close();
		
		
		

	}

}

class Menu{
	
	
	
	
	public static void menuPrint() {
		System.out.println("=======");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("==========");
		
	}
	
	public static void runMenu(int user) {
		switch(user) {
		case 1:
			System.out.println("==========");
			System.out.println("Product sales");
			System.out.println("==========");
			break;
		case 2:
			System.out.println("==========");
			System.out.println("Receiving the product");
			System.out.println("==========");
			break;
		case 3:
			System.out.println("==========");
			System.out.println("Product inquiry");
			System.out.println("==========");
			break;
		case 4:
			System.out.println("==========");
			System.out.println("Sales inquiry");
			System.out.println("==========");
			break;
		case 5:
			System.out.println("==========");
			System.out.println("Exit the program");
			System.out.println("==========");
			break;
		default:
		System.out.println("Wrong Input!");
		}
	}
	
	public void Sales() {
		
	}
	public void Receiving() {
			
	}
	public void Inquiry() {
		
	}
	public void SalesInquiry() {
		
	}
	

}


class Homeappliances extends Menu{
	
}
class Radio extends Homeappliances{
	
	
}
class TV extends Homeappliances{
	
}
class Airconditioner extends Homeappliances{
	
}
