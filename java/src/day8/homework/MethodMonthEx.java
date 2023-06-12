package day8.homework;

import java.util.Scanner;

public class MethodMonthEx {

	public static void main(String[] args) {
		// 월을 입력받아 월에 맞는 영어를 출력하시오.
		// Ex) 3 = march
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		int month = sc.nextInt();
		System.out.println(month(month));
		sc.close();
	}
	
	
	public static String month(int month) {
		switch(month) {
		case 1:
			return "january";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "Nomember";
		case 12:
			return "December";
			default:
				return "Invalid input.";
			
		}
		
	}
	
	/** 월이 주어지면 주어진 월의 영문명을 알려주는 메서드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 월의 영문 => String
	 * 메서드명 : getMonth
	 */
	

}
