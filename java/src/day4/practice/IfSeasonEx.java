package day4.practice;

import java.util.Scanner;

public class IfSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		3,4,5 : 봄
		6,7,8 : 여름
		9,10,11 : 가을
		12,1,2 : 겨울
		그 외 : 잘못된 월
		*/
		int month;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input month : ");
		
		month = sc.nextInt();
		
		
		/*
		
		int spring = 3,4,5;
		int summer = (6,7,8);
		int fall = (9,10,11);
		int winter = (12,1,2);
		
		
		if(month == spring ) {
			System.out.println(month + "월은 봄입니다.");
		}else if(month == summer) {
			System.out.println(month + "월은 여름입니다.");
		}else if(month == fall) {
			System.out.println(month + "월은 가을입니다");
		}else if(month == winter) {
			System.out.println(month + "월은 겨울입니다");
		}
		
		else {
			System.out.println("Invalid input.");
		}
		*/
		if(month >= 3 && month < 6 ) {
			System.out.println(month + "월은 봄입니다.");
		}else if(month >= 6 && month < 9) {
			System.out.println(month + "월은 여름입니다.");
		}else if(month >= 9 && month < 12) {
			System.out.println(month + "월은 가을입니다");
		}else if(month == 12 || month == 1 || month == 2) {
			System.out.println(month + "월은 겨울입니다");
		}
		
		else {
			System.out.println("Invalid input.");
		}
		sc.close();

	}

}
