package day5.Practice;

import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num의 약수를 출력하는 코드를 작성하시오
		// 약수 : A를 B로 나누었을 때 나머지가 0이면 B는 A의 약수이다.
		// 12의 약수 : 1, 2, 3, 4, 6, 12
		// 반복횟수 : i는 1부터 num까지 1씩 증가
		// 규칙성 : i가 num의 약수이면 i를 출력
		//		=> num을 i로 나누었을 때 나머지가 0 과 같다면 i를 출력
		
		int num1;
		int i = 1;
		Scanner sc = new Scanner(System.in);
		
		
		//정수입력
		System.out.println("input number : ");
		num1 = sc.nextInt();
				
		//반복문, i는 1부터 num까지 1씩 증가
		while(i++ <= num1) {
			//num을 i로 나누었을 때 나머지가 0 과 같다면 i를 출력
			if(num1 % i == 0) {
				System.out.println(i);
			}
			
		}
		
		sc.close();
	

	}

}
