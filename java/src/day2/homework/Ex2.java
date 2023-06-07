package day2.homework;

import java.util.*;

public class Ex2 {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);



		System.out.println("정수를 입력하시오");

		int A = sc.nextInt();

		System.out.println("정수를 입력하시오");

		int B = sc.nextInt();

		

		System.out.println(A + B);

		System.out.println(A - B);

		System.out.println(A * B);

		System.out.println((double)A / B);

		System.out.println(A % B);
		 */
		System.out.println("두 정수를 입력하시오");// 스캐너 생성
		Scanner sc = new Scanner(System.in);// 정수 입력 
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		// 두 정수의 산술연산 계산
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = num1 / (double)num2;
		int mod = num1 % num2;
		
		System.out.println(num1 + "+" + num2 + "=" + sum);
		System.out.println(num1 + "-" + num2 + "=" + sub);
		System.out.println(num1 + "*" + num2 + "=" + mul);
		System.out.println(num1 + "/" + num2 + "=" + div);
		System.out.println(num1 + "%" + num2 + "=" + mod);
		//System.out.println(A + "%" + B + "=" + (A % B); 도 가능
		// (* / %)는 (+ -) 보다 우선순위가 높기때문에 ()가 필요없지만, (+ -)는 우선순위가 낮기때문에 ()가 필요하다.
				
		sc.close();
	}

}
