package day4.practice;

import java.util.Scanner;

public class IfScoreEx2 {

	public static void main(String[] args) {
		/*
		성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 
		90~100 A
		80~90 B
		70~80 C
		60~70 D
		60 미만 F
		0보다 작거나 100보다 큰 경우 : wrong score
		*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input your score : ");
		
		int num = sc.nextInt();
		/* score가 0미만이거나 100 초과이면 wrong score!
		 * score가 90이상이면 A
		 * score가 80이상이면 B
		 * score가 70이상이면 C
		 * score가 60이상이면 D
		 * 아니면 F
		 *  */
		if(num > 100 || num < 0) {
			System.out.println("wrong score");
		}else if(num >= 90) {
			System.out.println("A");
		}else if(num >= 80) {
			System.out.println("B");
		}else if(num >= 70) {
			System.out.println("C");
		}else if(num >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}

	}

}
