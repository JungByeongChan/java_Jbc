package day4.homework;

import java.util.Scanner;

public class TriangleEx {

	public static void main(String[] args) {
		/*
		정수 num가 짝수이면 num에 2를 나누고, 정수 num가 홀수이면 num에 1을 더한 후, num를 출력하는 코드를 작성하세요.
		(package : day4.homework, file : NumberEx)
		*/
		
		System.out.println("inpur number : ");
		
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		
		
		if(num % 2 == 0) {
			System.out.println(num / 2);
		}else {
			System.out.println(num + 1);
		}
		
		
		
		
		
		sc.close();

	}

}
