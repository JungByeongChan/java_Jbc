package day4.homework;

import java.util.*;

public class NumberEx {

	public static void main(String[] args) {
		/*
		두 정수를 입력받아 두 정수 중 큰 수를 출력하는 코드를 작성하세요.
		(package : day4.homework, file : MaxEx)
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력하세요");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		if(num1 > num2) {
			System.out.println(num1 + " 과" + num2 + " 중에서 더 큰 숫자는 " + num1 + "입니다.");
		}else {
			System.out.println(num1 + " 과" + num2 + " 중에서 더 큰 숫자는 " + num2 + "입니다.");
		}
		
		
		sc.close();
		


	}

}
