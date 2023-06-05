package day5.WhileEx;

public class HelloworldEx {

	public static void main(String[] args) {
		// Hello World를 10번 출력하는 코드를 만드시오.
		/* 반복 횟수 : 10번, 1번부터 10번까지 1씩 증가 
		 * => 변수의 초기값 : 1
		 * => 조건식 : 10까지 => 1 <= 10까지
		 * => 증가하는 식 : 1씩 증가
		 * 규칙성 : Hello World를 출력
		 * 
		 * */
		//System.out.println("Hello world");
		int i = 3; // 변수의 초기값 : 1
		int max = 5;
		
		while(i <= max) {
			System.out.println("Hello World");
			++i;//i는 1씩 증가, i++, i = i + 1, i += 1 도가능
		}
		System.out.println("==================");
		
		/*
		 *  반복횟수 : i는 10부터 1까지 1씩 감소
		 */
		i = max;
		while(i >= 1 ) {
			System.out.println("Hello world");
			--i;
		}
		System.out.println("==================");
		i = max;
		while(--i > 0 ) {
			System.out.println("Hello world");
		}

	}

}
