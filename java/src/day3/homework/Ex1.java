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
		
		
		int A = sc.nextInt();
		
		System.out.println("Do you pass " + A + "points?" + (A >= 60));
		
		System.out.println("당신의 성적은 몇점입니까?");
		
		int B = sc.nextInt();
		boolean result = B >= 60;
		
		System.out.println("Do you pass " + A + "points?" + result);
		
		sc.close();
		
	}

}
