package day6.forex;

public class HelloWorldEx {

	public static void main(String[] args) {
		// for문을 이용하여 Hello World를 5번 출력하는 예제
		/* 반복횟수 : i는 1부터 5까지 1씩 증가 
		 * 규칙성 : Hello World를 출력
		 * 	 */
		
		int i;
		
		for(i = 1 ; i <= 5 ; i++ ) {
			System.out.println("Hello World");
		}
		
		System.out.println("========================");
		
		i = 1;
		while(i++ <= 5) {
			
			System.out.println("Hello World");
		}

	}

}
