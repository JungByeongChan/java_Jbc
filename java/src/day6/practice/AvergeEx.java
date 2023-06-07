package day6.practice;

import java.util.Scanner;

public class AvergeEx {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 구하는 코드를 작성하시오
		
		int math,english,korean;
		double average;
		char menu = 'y';
	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to find the average?(yes or no) : ");
		menu = sc.next().charAt(0);
		
		
		while(menu != 'n') {
			
			System.out.println("input math score : ");
			math = sc.nextInt(); 
				
				
			System.out.println("input english score : ");
			english = sc.nextInt();
		
		
			System.out.println("input korean score : ");
			korean = sc.nextInt();
			
			average = math + english + korean / 3.0;
			
			System.out.println(average);
			System.out.println("continew?(y/n) :");
			menu = sc.next().charAt(0);
			
			
			}

		System.out.println("exit!");

		
		
		
		
		sc.close();

	}

}
