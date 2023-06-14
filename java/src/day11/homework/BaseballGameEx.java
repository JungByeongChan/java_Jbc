package day11.homework;

import java.util.Scanner;

public class BaseballGameEx {

	public static void main(String[] args) {
		/*
		  	숫자 야구 게임을 구현하시오.
		  	1~9 사이의 중복되지 않은 세 수를 맞추는 게임
		  	규칙 :
		  	B : 같은 숫자가 있지만 위치가 다름
		  	S : 같은 숫자가 있고 위치가 같음
		  	3O : 일치하는 숫자가 하나도 없음
		  	
		  	
		  	
		 */
		
		int min = 1; int max = 9;
		int list[] = new int[3];
		
		
		boolean cheaklist[] = new boolean[10];
		for(int i = 0 ; i < 3 ; ) {
			int random = (int)(Math.random() * (max - min + 1) - min );
			if(!cheaklist[random]){
				//random을 배열에 저장.
				list[i] = random;
				//i를 증가. 
				i++;
				//cheaklist배열에 random번지에 있는 값을 true로 변경
				cheaklist[random] = true;
			}
			
		}
		for(int i = 0; i < 3 ; i ++) {
			System.out.print(list[i]);
		}
		System.out.println("\n");
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("int put number :");
		
		int num = sc.nextInt();
		
		
		
		

	}

}
