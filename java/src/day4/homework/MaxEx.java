package day4.homework;

import java.util.*;

public class MaxEx {

	public static void main(String[] args) {
		/*
		 * 국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		 
		 (package : day4.homework, file : ScoreAverageEx)성적은 정수.
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input your korean score : ");
		
		int korean = sc.nextInt();
		
		System.out.print("input your english score : ");
		
		int english = sc.nextInt();
		
		System.out.print("input your math score : ");
		
		int math = sc.nextInt();
		
		String str =  "" + (korean + english + math) / 3.0 ;
		
		System.out.print(str);
		
		System.out.print((korean + english + math) / 3);


	}

}
