package day3.homework;

import java.util.Scanner;


public class Ex5 {

	public static void main(String[] args) {
		/* 성별(M:남성,W:여성)를 입력받아 여성인지 확인하는 코드를 작성하세요. 조건 연산자 이용
		(package : day3.homework, file : Ex1_conditional) 
		input gender : 
		M
		Are you a women? false

		input gender : 
		W
		Are you a women? true
		*/

		/*Scanner sc = new Scanner(System.in);
		
		System.out.println("성별을 입력하시오");
	
		
		int num1 = sc.nextInt();
		char ch = 'm';
		String str1;
		str1 = num1 == ch ? "true" : "false";
		
				
		System.out.println("당신은 여성입니까?" + str1 );
		
		int sr = sc.nextInt();
		
		String str2;
		str2 = sr == ch ? "true" : "false";
		
		System.out.println("당신은 여성입니까? " + str2);
		
		sc.close();
		*/
		
		char gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		gender = sc.next().charAt(0);
		boolean result = gender == 'W' ?  true : false;
		
		System.out.println("Are you a women? " + result);
		
		sc.close();
		
		
		

	}

}
