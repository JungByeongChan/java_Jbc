package day5.Practice;

import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num이 소수인지 아닌지를 판별하는 코드를 작성하시오.
		// 소수 : 약수가 1과 자기 자신밖에 없는 수
		// 소수 : 2,3,5,7,11,13 등
		// 반복횟수 : i는 1부터 num까지 1씩 증가
		// 규칙성 : i가 num의 약수이면 i를 출력
		//		=> num을 i로 나누었을 때 나머지가 0 과 같다면 i를 출력
		// 반복문 종료 후 : count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		
		
		int num;
		int i = 1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input number : ");
		
		num = sc.nextInt();
		int count = 0;
		
		//반복문, i는 1부터 num까지 1씩 증가
		while(i++ <= num) {
			//i가 num의 약수이면 약수의 개수 count를 1 증가
			if(num % i == 0) {
				count++;
				
			}
		}
			//count가 2이면 소수라고 출력, 아니면 소수가 아님이라고 출력
		System.out.println(count == 2 ? " prime number" : "  not prime number");
		
		if(count == 2) {
			System.out.println(num + " is a prime number");
		}else {
			System.out.println(num + " is a not prime number");
		}
			
			
		
		
		
		
		
		sc.close();
		

	}

}
