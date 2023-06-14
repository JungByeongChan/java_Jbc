package day11.practice;

public class DivisorEx {

	public static void main(String[] args) {
		// 정수 num의 약수들을 배열에 저장하는 코드를 작성하시오. 약수는 최대 10개까지 저장
		/*
		  12 : 1,2,3,4,6,12
		  0번지 : 1
		  1번지 : 2
		  2번지 : 3
		  3번지 : 4
		  5번지 : 12
		 */
		
		int divisor[] = new int[10];
		int num = 288;
		int count = 0;
		for(int i = 1 ; num >= i ; i++) {
			if(num % i == 0) {
				
				divisor[count] = i;
				count++;
				
				
			}
			if(count == divisor.length) {
				break;
			}
			
		}
		for(int i = 0; i < count ; i++) {
			System.out.println(divisor[i]);
		}
		
		
		
		

	}

}
