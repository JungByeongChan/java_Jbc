package day3.homework;

import java.util.*;

public class Ex1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적이 60점이상인지 확인하는 코드를 작성하시오.
		예 :
		input score :
		65
		Do you pass 65 points? true
		
		input score :
		45
		Do you pass 45 points? false
					
		*/
		
		Scanner sc = new Scanner(System.in);
		

		System.out.println("당신의 성적은 몇점입니까?");
		
		
		int num1 = sc.nextInt();
		
		System.out.println("Do you pass " + num1 + "points?" + (num1 >= 60));
		
		System.out.println("당신의 성적은 몇점입니까?");
		
		int num2 = sc.nextInt();
		boolean result = num2 >= 60;
		
		System.out.println("Do you pass " + num1 + "points?" + result);
		
		sc.close();
		
	}

}
