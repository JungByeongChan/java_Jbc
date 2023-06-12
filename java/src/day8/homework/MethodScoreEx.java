package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {

	public static void main(String[] args) {
		// 성적을 입력받아 학점을 출력하는 코드를 작성하시오.
		double num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("input your score : ");
		num = sc.nextInt();
		
		score(num);
		
		
		
		
		
		
		
		sc.close();

	}
	public static void score(double num) {
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
