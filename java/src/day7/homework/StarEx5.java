package day7.homework;

public class StarEx5 {

	public static void main(String[] args) {
		/* 아래와 같이 코드를 출력하시오.
		 	*		i = 1 공 = 3		
		   ***		i = 2 공 = 2
		  *****		i = 3 공 = 1
		 *******	i = 4 공 = 0 // 공백 half - i 별 = 2 * i - 1
		  *****		i = 5 공백= 1		* = 5 = 2*3-1
		   ***		i = 6 공 = 2		* = 3 = 2*2-1
		    *		i = 7 공 = 3		* = 1 = 2*1-1
		  				  공 =i-half	* = 2*(num+1-i)-1 => 2*(num-i)+1 로 바꿀수있음
		 */

	
	
	/*
	int i, j ;
	for(i = 1 ; i <= 7 ; i++) {
		for(j = 1 ; j <= 4 - i ; j++) {
			System.out.print(" ");
		}
		for(j = 1 ; j <= i ; j++) {
			System.out.print("*");
		}
		for(j = 1 ; j <= i-1 ; j++) {
			System.out.print("*");
		}
		for(j = 5 ; j <= 4 + i ; j--) {
			System.out.println(" ");
		}
			System.out.println("");
	}*/
	/*
	for(int i = 1 ; i <= 4 ; i++) {
		for(int j = 1 ; j <= 4-i ; j++) {
			System.out.print(" ");
		}for(int j = 1 ; j <= 2*i -1 ; j++) {
			System.out.print("*");
		}
		
		System.out.println();
	}
	
	
	
	
	for(int i = 4 ; i >= 1 ; i--) {
		for(int j = 1 ; j <= 4 - i ; j++) {
			System.out.print(" ");
		}
		for(int j = 1 ; j <= 2 * i - 1 ; j++) {
			System.out.print("*");
		}//for(int j = 1 ; j <= 1; j++) {
		//	System.out.print("*");
		//}
		System.out.println();
	}
	*/
	
	
	/*
	for(int i = 1 ; i <= 4 ; i++) {
		for(int j = 4 ; j <= 4 + i ; j++){
			System.out.print("*");
		}
		for(int j = 1 ; j <= 2 * i -1 ; j++) {
			System.out.print(" ");
		}
		System.out.println();
	}*/
	
	
	/*
	for(int i = 1 ; i <= 3 ; i++) {
		for(int j = 1 ; j <= i ; j++) {
			System.out.print("*");
		}for(int j = 1 ; j <= 2 * i - 1 ; j++) {
			System.out.print(" ");
		}
		System.out.println("");
		
	}*/
		
	int num = 7; // 7줄이기 때문
	for(int i = 1 ; i <= num; i++) {
		//4줄 => (num + 1) / 2 중간에 대칭이되는 시점이기 떄문
		int half = (num+1) / 2; // 공백 + 별 = 하프이기때문에 공백 = half -i / 별 = 2 * i -1
		if(i <= half) {
			// half - i개 공백 출력
			for(int j = 1; j <= half - i ; j++) {
				System.out.print(" ");
			}
			// 2 * i - 1개 = * 출력
			for(int j = 1; j <= 2 * i - 1 ; j++) {
				System.out.print("*");
			}// 엔터 출력
			System.out.println();
		}//3줄
		//
		else {
			// half - i개 공백 출력
			for(int j = 1; j <= i - half ; j++) {
			System.out.print(" ");
			}
			// 2 * i - 1개 = * 출력
			for(int j = 1; j <= 2 * (num - i) + 1 ; j++) {
			System.out.print("*");
			}// 엔터 출력
			System.out.println();
		}
		
		
		
		
	}
	}	
}

