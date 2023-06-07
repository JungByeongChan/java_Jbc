package day6.practice;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		// UpDown 게임을 하는 코드를 작성하세요.
		
		//한판이 끝나면 더 할것인지를 물어서 n을 입력하면 종료, y를 입력하면 이어서 게임이 진행
		

		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		char menu;
		
		System.out.println(random);
		
		
		Scanner sc = new Scanner(System.in);
		sc.close();

		System.out.println("game start?(y or n) : ");
		
		menu = sc.next().charAt(0);
		

		
		
		
		for( ; menu != 'n' ;) {
			System.out.println("input number : ");
			
			int num = sc.nextInt();
			
			for( ; num != random ; ) {
				if(num < random) {
				 System.out.println("Up!");
				
				}else if(num > random) {
					System.out.println("Down!");
				}else {
					System.out.println("Good!");
				}
			
		}
		System.out.println("onemore? :");
		menu = sc.next().charAt(0);
		}
		System.out.println("Exit");

	}
	

}
