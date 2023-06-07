package day2.homework;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		

		System.out.println("두 정수와 산술 연살자를 입력하시오");

		String str = sc.nextLine();



		System.out.println(str);
		*/
		int A, B;
		char opertator;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수와 산술연산자를 입력하세요 (예:1 + 2)");
		A = sc.nextInt();
		opertator = sc.next().charAt(0);
		B = sc.nextInt();
		System.out.println("" + A + opertator + B);
		
		sc.close();
		
	}

}
