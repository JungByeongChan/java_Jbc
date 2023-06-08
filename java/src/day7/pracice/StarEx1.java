package day7.pracice;

public class StarEx1 {

	public static void main(String[] args) {
		/* ***** i = 1 *=5
		 * ***** i = 2 *=5
		 * ***** i = 3 *=5
		 * ***** i = 4 *=5
		 * ***** i = 5 *=5
		 * 		 */
		/* 외부 반복문
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 실행문 : *개를 출력 후 엔터
		 */
			/* 5개를 출력
			 * 내부 반복문
			 * 반복 횟수 : j는 1부터 5까지 1씩 증가
			 * 규칙성 : *을 출력
			 * 	 */
		
			// 엔터
		
		int i;
		char ch= '*';
		
		for(i = 1 ; i <= 5 ; i++ ) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
