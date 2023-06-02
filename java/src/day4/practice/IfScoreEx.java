package day4.practice;

import java.util.Scanner;

public class IfScoreEx {

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
		if(num >= 90 && num < 101) {
			System.out.println(num + "" + " you Rank" + "=" + " A");
		}else if(num >= 80 && num <= 89) {
			System.out.println(num + "" + " you Rank" + "=" + " B");
		}else if(num >= 70 && num <= 79) {
			System.out.println(num + "" + " you Rank" + "=" + " C");
		}else if(num >= 60 && num <= 69) {
			System.out.println(num + "" + " you Rank" + "=" + " D");
		}else if(num < 60 && num >= 0) {
			System.out.println(num + "" + " you Rank" + "=" + " F");
		}else {
			System.out.println("wrong score");
		}

	}

}
