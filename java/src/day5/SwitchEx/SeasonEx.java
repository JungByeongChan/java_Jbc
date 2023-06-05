package day5.SwitchEx;

import java.util.Scanner;

public class SeasonEx {

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
		
			
			
		switch(month) {
		case 1: case 2: case 12: // case 1,2,12: // 도 가능하지만 JDK 7버전 이후로 가능하다
			System.out.println(month + " is a winter");
			break;		
		case 3: case 4: case 5:
			System.out.println(month + " is a winter");
			break;		
		case 6: case 7: case 8:
			System.out.println(month + " is a winter");
			break;	
		case 9,10,11:
			System.out.println(month + " is a winter");
			break;
		}
		
		/*
		switch(month) {
		case 1:
			System.out.println(month + " is a winter");
			break;
		case 2:
			System.out.println(month + " is a winter");
			break;
		case 3:
			System.out.println(month + " is a sptring");
			break;
		case 4:
			System.out.println(month + " is a sptring");
			break;
		case 5:
			System.out.println(month + " is a sptring");
			break;
		case 6:
			System.out.println(month + " is a summer");
			break;
		case 7:
			System.out.println(month + " is a summer");
			break;
		case 8:
			System.out.println(month + " is a summer");
			break;
		case 9:
			System.out.println(month + " is a fall");
			break;
		case 10:
			System.out.println(month + " is a fall");
			break;
		case 11:
			System.out.println(month + " is a fall");
			break;
		case 12:
			System.out.println(month + " is a winter");
			break;
		default:
		System.out.println(month + " is a not season");
			
		sc.close();
		
		}
		*/
		

	}

}
