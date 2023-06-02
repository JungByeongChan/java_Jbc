package day4.practice;

import java.util.Scanner;

public class IfMultipleEx2 {

	public static void main(String[] args) {
		/* 정수 num을 입력받아 num이 2의 배수이면 2의 배수라고 출력하고,
		3의 배수이면 3의 배수라고 출력하고, 6의 배수이면 6의 배수라고 출력하고,
		2,3,6의 배수가 아니라면 2,3,6의 배수가 아니라고 출력하는 코드를 작성하시오.
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number :");
		
		int num1 = sc.nextInt();
		
		if(num1 % 6 == 0) {
			System.out.println(num1 + " = " + "" + "multiple of 6");
		}else if(num1 % 2 == 0) {
			System.out.println(num1 + " = " + "" + "multiple of 2");
		}else if(num1 % 3 == 0) {
			System.out.println(num1 + " = " + "" + "multiple of 3");
		}
		else {
			System.out.println(num1 + " = " + "" + "not multiple of 2,3,6");
		}
		/* 아래도 가능 // 6의 배수가 아닌 2의 배수만 찾기 위해 2의배수이지만 3의 배수가 아닌 정수를 확인
		 	if(num1 % 2 == 0 && num % 3 != 0) {
			System.out.println(num1 + " = " + "" + "multiple of 2");
		}else if(num1 % 3 == 0 && num % 2 != 0) {
			System.out.println(num1 + " = " + "" + "multiple of 3");
		}else if(num1 % 6 == 0) {
			System.out.println(num1 + " = " + "" + "multiple of 6");
		}
		else {
			System.out.println(num1 + " = " + "" + "not multiple of 2,3,6");
		}
 
		 */
		
		sc.close();
	}

}
