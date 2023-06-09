package day8.practice;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		// 월을 입력받아 계절을 출력하는 코드를 작성하시오
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input month :");
		int num = sc.nextInt();
		
		month(num);
		
		
		
		
		
		
		sc.close();

	}
	public static void month(int num) {
		switch(num) {
		case 1,2,12:
			System.out.println("winter");
		break;
		case 3,4,5:
			System.out.println("spring");
		break;
		case 6,7,8:
			System.out.println("summer");
		break;
		case 9,10,11:
			System.out.println("fall");
		break;
		default:
			System.out.println("not month");
			
		}
			
		
	}
	public static String month1(int month) {
		if(month == 3 ||month == 4 || month == 5) {
			return "Spring";
		}else if(month == 6 ||month == 7 || month == 8) {
			return "summer";
		}else if(month == 9 ||month == 10 || month == 11) {
			return "fall";
		}else if(month == 12 ||month == 1 || month == 2) {
			return "winter";
		}else {
			return "";
		}
	}

}
