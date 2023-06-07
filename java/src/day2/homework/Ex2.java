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
		int A = sc.nextInt();
		int B = sc.nextInt();
		// 두 정수의 산술연산 계산
		int sum = A + B;
		int sub = A - B;
		int mul = A * B;
		double div = A / (double)B;
		int mod = A % B;
		
		System.out.println(A + "+" + B + "=" + sum);
		System.out.println(A + "-" + B + "=" + sub);
		System.out.println(A + "*" + B + "=" + mul);
		System.out.println(A + "/" + B + "=" + div);
		System.out.println(A + "%" + B + "=" + mod);
		//System.out.println(A + "%" + B + "=" + (A % B); 도 가능
		// (* / %)는 (+ -) 보다 우선순위가 높기때문에 ()가 필요없지만, (+ -)는 우선순위가 낮기때문에 ()가 필요하다.
				
		sc.close();
	}

}
