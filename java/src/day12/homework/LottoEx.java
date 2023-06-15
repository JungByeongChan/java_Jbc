package day12.homework;

import java.util.Scanner;

import array.Array;

public class LottoEx {

	public static void main(String[] args) {
		// 로또 번호를 생성하고, 사용자가 번호를 입력하면 몇등인지 출력하는 코드를 작성하세요.
		/*
		  1등 : 번호 6개
		  2등 : 번호 5개 + 보너스
		  3등 : 번호 5개
		  4등 : 번호 4개
		  5등 : 번호 3개
		  number : [1,3,40,23,24,45]
		  bonus : 2
		  user : 1,2,3,4,5,6
		  losing ticket!(꽝)
		 */

		
		Scanner sc = new Scanner(System.in);
		
		
		
		
		int number[] = new int[6];		
		int user[] = new int[6];
		int max = 100; int min = 1;
		int bonus = (int)(Math.random() * (max - min + 1) - min);
		Array.createRandomArray(min, max, number);
		Array.printArray(number);
		Array.printArray(user);
		System.out.println(bonus);
		
		do {
			//사용자가 숫자 6개를 입력
			System.out.println("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			//사용자 입력 체크
			// 1 1 3 | 1 1 3
			if(Array.arrayCheck(user)) {
				System.out.println("You must not enter the same number!");
				continue;
			}
			
			//판별
			
			// 입력한 번호가 당첨이 판별
			
			
			// 보너스가 맞았는지 판별
			
			
			
			// 등수 출력
			
		}while( ); // 종료시점
		System.out.println("Good");
		
		
		sc.close();
	}
		
		
		
		
		
		
		
}


class atari{
	
	
}