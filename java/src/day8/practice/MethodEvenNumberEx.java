package day8.practice;

import java.util.Scanner;

public class MethodEvenNumberEx {

	public static void main(String[] args) {
		// 정수 num을 입력받아 짝수인지 아닌지 판별하는 코드를 작성하시오.
		// 단, 메서드를 이용할것

		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		int num1 = sc.nextInt();
		
		
		System.out.println(sum(num1));
		
		printEvenNumber(num1);
		if(mod(num1,2) == 0) { 
				System.out.println("Even Numver.");
		}else {
				System.out.println("Odd Numver");
			}
		
		sc.close();
		
		if(isEvenNumber(num1)) {
			System.out.println("Even Numver.");
		}else {
				System.out.println("Odd Numver");
			}
		if(isMultiple(num1, 2)) {
			System.out.println("Even Numver.");
		}else {
				System.out.println("Odd Numver");
			}
	}
	
	public static String sum(int num1){
		return num1 % 2 == 0 ? "Even number" : "not Even number" ;
	}
	/**
	 * num이 주어지면 num이 짝수인지 홀수인지 출력하는 메서드
	 * @param num : 판별할 정수
	 * @return : void(없음)
	 * 메서드명 : printEvenNumber
	 */
	public static void printEvenNumber(int num) {
		if(num % 2 == 0) {
			System.out.println("Even Numver.");
		}else {
			System.out.println("Odd Numver");
		}
	}
	/**
	 * num1과 num2가 주어지면 num1을 num2로 나누었을 때 
	 * 나머지를 알려주는 메서드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 나누었을 때 나머지 => 정수 => int
	 * 메서드명 : mod
	 */
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
	
	/**
	  num이 주어지면 num이 짝수인지 홀수인지 알려주는 메서드
	  매개변수 : 판별할 정수 => int num
	  리턴타입 : 짝수인지(참) 홀수인지(거짓) => boolean
	  메서드명 : isEvenNumber
	 */
	public static boolean isEvenNumber(int num) {
		return num % 2 == 0;
	}
	/**
	  num1과 num2가 주어지면 num1이 num2의 배수인지 아닌지 알려주는 메서드
	  매개변수 : 두 정수 => int num1, int num2
	  리턴타입 : 배수인지(참) 아닌지(거짓) => boolean
	  메서드명 : isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}

}
