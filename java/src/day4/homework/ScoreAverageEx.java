package day4.homework;

import java.util.*;

public class ScoreAverageEx {

	public static void main(String[] args) {
		/*
		세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		(package : day4.homework, file : TriangleEx)
		세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
		input 3 integer num : 
		1 2 3 
		Unable to create triangle.
		input 3 integer num : 
		2 2 3 
		Able to create triangle.
		*/
		
		Scanner sr = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		
		int num1 = sr.nextInt();
		
		System.out.println("정수를 입력하세요.");
		int num2 = sr.nextInt();
		
		System.out.println("정수를 입력하세요.");
		int num3 = sr.nextInt();
		
		if((num1 + num2) >= num3) {
			System.out.println(num1 + "+" + num2 + "=" + num3 + " 따라서" + " 삼각형이 만들어질 수 있습니다.");
		}else {
			System.out.println(num1 + "+" + num2 + "=" + num3 + " 따라서" + " 삼각형이 만들어질 수 없습니다.");
		}
		
		String str = (num1 + num2) >= num3 ? "가능합니다" : "불가능합니다" ;
		
		System.out.println(num1 + "+" + num2 + "=" + num3 + " 따라서" + str);

	}

}
