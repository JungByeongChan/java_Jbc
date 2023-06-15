package day11.homework;

import java.util.Scanner;

import array.Array;

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
		/*
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
		
		*/
		//숫자 야구게임을 구현하시오.
		int com[] = new int[3];		//랜덤으로 생성된 수를 저장할 배열
		int  user[] = new int[3];	// 사용자가 입력한 수를 저장할 배열
		int min = 1, max = 9;
		int strike = 0; //스트라이크 개수
		int ball = 0; // 볼의 개수
		Scanner sc = new Scanner(System.in);
		
		
		//맞춰야 할 숫자 3개를 랜덤으로 생성
		Array.createRandomArray(min, max, com);
		Array.printArray(com);//나중에 주석처리
		
		
		//반복문
		do {
			//사용자가 숫자 3개를 입력
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
			strike = 0;
			ball = 0;
			// 스트라이크 개수 판별
			strike = strike(com,user);
			
			// 볼의 개수 판별
			ball = ball(com, user);
			
			
			// 스트라이크와 볼의 개수에 맞게 출력
			printResult(strike, ball);
		}while(strike < 3); // 종료시점
		System.out.println("Good");
		
		
		sc.close();
	}
	
	/**
	 * 스트라이크 개수를 판별하는 메서드
	 * => 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr[2]
	 * 리턴타입 : 같은 번지에 있는 값들이 몇개 같은지 = > 몇개 => int
	 * 메서드명 : Strike
	 */
	public static int strike(int arr1[], int arr2[]) {
		// 배열 생성이 안된 배열이 1라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		// 배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하고 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		int count = 0; // 스트라이크 개수
		for(int i = 0 ; i < size ; i++) {
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 스트라이크 개수를 판별하는 메서드
	 * => 두 배열에서 다른 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr[2]
	 * 리턴타입 : 다른 번지에 있는 값들이 몇개 같은지 = > 몇개 => int
	 * 메서드명 : ball
	 */
	
	public static int ball(int arr1[], int arr2[]) {
		// 배열 생성이 안된 배열이 1라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		
		int count = 0; // 볼의 개수
		
		//다른 번지를 비교해서 찾아도 되지만
		//두 배열에서 같은 숫자의 개수에서 스트라이크의 개수를 빼면 볼의 개수
		for(int tmp : arr1) {
			//배열1에서 꺼낸 값이 arr2에 있으면 개수를 증가
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1,arr2);
		//이중 반복문을 이용해서 다른 번지를 비교하는 코드
		/*
		 * for(int i = 0 ; i < arr1.length; i++) {
		 
			for(int j = 0; j<arr2.length; j++) {
				if(i ==j){
					continue;
				}
				if(arr1[i] == arr2[i]) {
					count++;
				}
			}
		}
		return count;
		*/
	}
	/**
	 * 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메서드
	 * 매개변수 : 스트라이크 개수, 볼의 개수 => int strike, int ball
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printResult
	 * 
	 */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball +"B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		System.out.println();
	}
	
}
