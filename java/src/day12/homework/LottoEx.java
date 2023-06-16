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
		
		//랜덤으로 로또번호 6개와 보너스 번호 1개를 생성
		//7개짜리 배열에 로또 번호를 생성하고, 앞에 6개는 로또번호, 마지막 1개는 보너스로 활용
		int lotto[] = new int[7];
		//7개짜리 로또번호 생성
		Array.createRandomArray(1, 45, lotto);
		
		//마지막 1개는 보너스로
		int bonus = lotto[6];
		int lotto2[] = new int[6];
		//로또1의 0번지부터 로또2의 0번지부터 6번지까지 붙여넣기
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		//로또 번호 정렬
		Array.sort(lotto2);
		
		System.out.println("number : ");
		Array.printArray(lotto2);
		System.out.println("bonus : " + bonus);
		
		//사용자가 번호를 6개 입력
		Scanner sc = new Scanner(System.in);
		int user[] = new int[6];
		
		System.out.println("user : ");
		for(int i = 0 ; i < user.length ; i++) {
			user[i] = sc.nextInt();
		}
				
		//중복입력하면 판별을 X
		if(Array.arrayCheck(user)) {
			System.out.println("Wrong number!");
			return;
		}
		
		
		//등수 판별
		int count = count(lotto2, user);
		printResult(count, Array.contains(user, bonus, user.length));
		
		
		sc.close();
		
		

		/*
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
	
		
		*/
	}
	/**
	 * 로또 번호와 사용자 번호가 주어지면 몇개가 같은지 알려주는 메서드
	 * 매개변수 : 로또 번호와 사용자 번호 => int lotto[], int user[]
	 * 리턴타입 : 몇개가 같은지 => 정수 = > int
	 * 메서드명 : count
	 *  */
	
	public static int count(int lotto[], int user[]) {
		if(lotto == null || user == null) {
			return 0;
		}
		
		int count = 0;
		for(int tmp : lotto) {
			if(Array.contains(user, tmp, user.length)) {
				count++;
			}
		}
		return count;
	}
	/**
	 * 일치하는 개수와 보너스번호와 사용자 번호가 일치하는 여부를 알려주면 등수를 출력하는 메서드
	 * 매개변수 : 일치하는 개수, 보너스 번호와 일치 여부
	 * 			=> int count, boolean checkBonus
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printResult
	 *  */
	public static void printResult(int count, boolean checkBonus) {
		switch(count) {
		case 6:
			System.out.println("1st");
			break;
		case 5:
			if(checkBonus) {
				System.out.println("2st");
			}
			else {
			System.out.println("3st");
			}
			break;
		case 4:
			System.out.println("4st");
			break;
		case 3:
			System.out.println("5st");
			break;
		default:
			System.out.println("Losing ticket!");
				
		}
	}

}