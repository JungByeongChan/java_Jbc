package day4.homework;

import java.util.*;

public class MaxEx {

	public static void main(String[] args) {
		/*
		두 정수를 입력받아 두 정수 중 큰 수를 출력하는 코드를 작성하세요.
		(package : day4.homework, file : MaxEx)
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력하세요");
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A >= B) {
			System.out.println(A + " 과" + B + " 중에서 더 큰 숫자는 " + A + "입니다.");
		}else {
			System.out.println(A + " 과" + B + " 중에서 더 큰 숫자는 " + B + "입니다.");
		}
		
		
		sc.close();
		


	}

}
