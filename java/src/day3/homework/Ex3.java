package day3.homework;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// 정수 num을 입력받아서 num이 0인지, 음수인지, 양수인지를 판별하는 코드를 if문을 이용하여 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		
	
				
		int num = sc.nextInt();
				
		if(num == 0) {
			System.out.println("0이다");
			}
		if(num > 0) {
			System.out.println("양수이다");
		}
		if(num < 0) {
			System.out.println("음수이다");
		}
		
		sc.close();
		
	}

}
