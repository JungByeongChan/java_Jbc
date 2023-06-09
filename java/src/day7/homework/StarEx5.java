package day7.homework;

public class StarEx5 {

	public static void main(String[] args) {
		/* 아래와 같이 코드를 출력하시오.
		 	*
		   ***
		  *****
		 *******
		  *****
		   ***
		    *
		  
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
		for(j = 5 ; j <= i ; j++) {
			System.out.println(" 5");
		}
			System.out.println("");
	}*/
	
	for(int i = 1 ; i <= 4 ; i++) {
		for(int j = 1 ; j <= 4-i ; j++) {
			System.out.print(" ");
		}for(int j = 1 ; j <= 2*i -1 ; j++) {
			System.out.print("*");
		}
		
		System.out.println();
	}/*
	for(int i = 1 ; i <= 4 ; i++) {
		for(int j = 4 ; j <= 4 + i ; j++){
			System.out.print("*");
		}
		for(int j = 1 ; j <= 2 * i -1 ; j++) {
			System.out.print(" ");
		}
		System.out.println();
	}*/
	
	
	
	
	
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
	
	
	/*
	for(int i = 1 ; i <= 3 ; i++) {
		for(int j = 1 ; j <= i ; j++) {
			System.out.print("*");
		}for(int j = 1 ; j <= 2 * i - 1 ; j++) {
			System.out.print(" ");
		}
		System.out.println("");
		
	}*/
	}	
}

