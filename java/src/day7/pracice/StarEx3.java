package day7.pracice;

public class StarEx3 {

	public static void main(String[] args) {
		// 다음과같은 코드를 출력하시오
		//     * 	 공백이 있음
		//   ***
		// *****
	
	for(int i = 1 ; i <= 5 ; i++) {
		for(int j = 1 ; j <= 5-i ; j++) {
			System.out.print(' ');
		}for(int j = 1 ; j <= i ; j++) {
		System.out.print('*');
		}
		System.out.println();
	}
	}
}
