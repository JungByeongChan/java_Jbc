package day8.practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		// 정수 num을 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하시오
		
		
		System.out.println(MethodEvenNumberEx.isMultiple(4, 2));
		// 다른 메서드 클래스를 소환해서 해당 클래스에서 만든 메서드를 사용할 수 있음

		Scanner sc = new Scanner(System.in);
		System.out.println("Input Number : ");
		int num = sc.nextInt();
		Multiple(num);

		sc.close();



	}
	public static void Multiple(int num) {
		if(num % 6 == 0) {
			System.out.println(num + " is a Multiple of 2,3,6");
		}else if(num % 3 == 0) {
			System.out.println(num + " is a Multiple of  Multiple 3");
		}else if(num % 2 == 0) {
			System.out.println(num + " is a Multiple of 2");
		}else {
			System.out.println(num + " isn't Multiple of 2,3,6");
		}

	}

}
