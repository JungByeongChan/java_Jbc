package day7.pracice;

public class StarEx2 {

	public static void main(String[] args) {
		// 다음과같은 코드를 출력하시오
		//   *
		//  ***
		// *****

		
		for(int i = 1 ; i <= 5 ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	
		
		int i = 1;
		while(i <= 5) {
			int j = 1;
			while(j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
	}

}
