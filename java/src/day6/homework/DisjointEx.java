package day6.homework;

import java.util.Scanner;

public class DisjointEx {

	public static void main(String[] args) {
		/* 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 만드시오.
		 * 서로소 : 최대 공약수가 1인 두 수의 관계
		 * input 2 numbers : 3 4
		 * Disjoint!(서로소)
		 * input 2 numbers : 8 4
		 * not Disjoint!(서로소 아님)
		 * 
		 * 
		 * 		 */
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		int i = 1;
		int gcd = 1;
		
		System.out.println("input 2 number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		while(i <= num1) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
			i++;
			
		}
		switch(gcd) {
		case 1:
			System.out.println(num1 + " and " + num2 + " is a Disjoints");
			break;
			default:
				System.out.println(num1 + " and " + num2 + " is not Disjoints");
			
		}
		String result = gcd == 1 ? " is a Disjoints" : " is not Disjoints";
		
		System.out.println(num1 + " and " + num2 + result);
		
		
		
		
		sc.close();

	}

}
