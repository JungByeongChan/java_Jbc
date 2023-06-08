package day7.pracice;

public class StarEx4 {

	public static void main(String[] args) {
		// 다음과같은 코드를 출력하시오
		/* 	 * 		i = 1 *=1  
		 * 	*** 	i = 2 *=3 
		 * ***** 	i = 3 *=5
		 * 		 */

			//방법 1
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 1 ; j <= 5-i ; j++) {
				System.out.print(" ");
			}for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}for(int j = 1 ; j <= i-1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			//방법 2
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 1 ; j <= 5-i ; j++) {
				System.out.print(" ");
			}for(int j = 1 ; j <= 2*i-1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

