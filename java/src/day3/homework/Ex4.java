package day3.homework;

import java.util.Scanner;

public class Ex4 {
	
	public static void main(String[] args) {
		
			//정수 num을 입력받아 num이 홀수인지 짝수인지 판별하는 코드를 작성하시오

		
			int num;
		
			Scanner sc = new Scanner(System.in);
		
		
			System.out.println("정수를 입력하시오");
		
		
		
			num = sc.nextInt();
			int sr = num % 2;
		
			if(sr == 0) {
			System.out.println("짝수입니다");
		
			}
		
			if(sr != 0) {
			System.out.println("홀수입니다");
		
			}
			sc.close();
	}
	
		
	
	
	 
}
