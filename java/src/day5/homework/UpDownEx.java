package day5.homework;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		/*
		  updown 게임
		  1~100 사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		  
		  랜덤한 수 : 45
		  input : 50
		  down!
		  input : 40
		  up!
		  input : 45
		  Good!
		  
		  맞출때까지 구현, good이 나올때까지 구현하면됨
		  
		 */
		
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		
		System.out.println(random);
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("input number : ");
		
		int num = sc.nextInt();
		
		
		
		while(num <= 100 && num >= 0) {
			
		if(num == random) {
				System.out.println("Good!");
				
			}else if(num < random) {
				System.out.println("up!");
				
			}
			 else{
				System.out.println("Down!");
			}
		 System.out.println("input number : ");
		 num = sc.nextInt();
		 
		
			
	}
			
	}
		
}
		
		
		
		
		
		
		
		

	


