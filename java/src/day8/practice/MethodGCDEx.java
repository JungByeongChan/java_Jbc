package day8.practice;

import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {
		// 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		int gcd = GCD(num1, num2);
		System.out.println(num1 + "and" + num2 + " gcd : " + gcd);
		
//
//		int i = 1; for(i = 1 ; i <= num1 ; i++) {
//			if(num1 % i == 0 && num2 % i == 0){
//				GCD = i;
//				}
//
//		}
//		System.out.println(num1 + num2 + "=" + GCD);


		System.out.println(GCD(num1, num2));
		
		
		System.out.println(gcd(num1, num2));
		sc.close();
	}


	public static int gcd(int num1, int num2) {
		int gcd = 1 ;
		for(int i = 1 ; i <= num1; i++) {//			
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}	

	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}

	public static int GCD(int num1, int num2) {
		for (int i = num1; i >= 1; i--)
			// i가 num1의 약수이다 == num1은 i의 배수이다
			if (isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		return 1;
	}

}
