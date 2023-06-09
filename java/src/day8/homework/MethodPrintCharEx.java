package day8.homework;

import java.util.Scanner;

public class MethodPrintCharEx {

	public static void main(String[] args) {
		// 다음과 같이 출력하기 위한 코드를 작성하시오.
		// ***** // 한번에 전부출력하라는 것이 아닌 1줄씩 출력하라는 의미
		// ***
		// ?????
		// ^^^^^
		Scanner sc = new Scanner(System.in);
		System.out.println("input String + number : ");
		String str = sc.next();
		int num1 = sc.nextInt();
		
		star(str, num1);
		
		sc.close();

	}
	
	public static void star(String str, int num1) {
		for(int i = 1; i <= num1 ; i++) {
			System.out.print(str);
		}
	}

}
