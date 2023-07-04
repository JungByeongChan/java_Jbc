package day25.test;

public class Test4 {

	public static void main(String[] args) {
	/*
	 * public static void main(String[] args) {
		//num가 짝수인지 홀수인지 판별하는 예제
		int num = 3;
		
		if(num % 2 == 0)
			System.out.println("짝수");
		else;
			System.out.println("홀수");

	}
	 */
		//num가 짝수인지 홀수인지 판별하는 예제
		int num = 3;
		
		if(num % 2 == 0){
			System.out.println("짝수");
		}else{//else옆의 ;때문에 else문의 실행문이 없음
			System.out.println("홀수");
		}
	}

}
