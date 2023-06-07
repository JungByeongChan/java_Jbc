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
				break;
				
			}else if(num < random) {
				System.out.println("up!");
				
			}
			 else{
				System.out.println("Down!");
			}
		 System.out.println("input number : ");
		 
		 num = sc.nextInt();
		}
		 // 이하는 강사풀이
		 // 반복문 : 맞출때까지 => 입력한 정수가 정답이 아니면 반복
		 int num1 = min - 1; // 1~100이 아닌 정수로 초기화 하면 됨. 최소값 -1을 해서 랜덤으로 나올 수 없는 수
		 
		 while(random != num1) {
			 //정수를 입력
			 System.out.println("input number(1~100) : ");
			 num1 = sc.nextInt();
			 //정수와 정답을 비교하여 판별
			 //num1이 random보다 크면 Down!, num1이 random보다 작으면 Up!, 아니면 Good!
			if(num1 > random){
				System.out.println("Down!");
			}else if(num < random) {
				System.out.println("Up!");
			}else {
				System.out.println("Good!");
			}
		 }
		 
		
			
	}
			
	}
		

		
		
		
		
		
		
		
		

	


