package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하시오.
		// 단, 메서드 이용 / 연산자를 잘못 입력한 경우는 없다고 가정
		// 0으로 나누는 일은 없다고 가정.
	
		Scanner sc = new Scanner(System.in);
		System.out.println("input Number : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(sum(num1, num2));
		System.out.println(sub(num1, num2));
		System.out.println(mul(num1, num2));
		System.out.println(div(num1, num2));
		System.out.println(mod(num1, num2));
		
		
		
		
		
		
		sc.close();
		
		
		
	}
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	public static double div(int num1, int num2) {
		return num1 / (double)num2;
	}
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	

}
