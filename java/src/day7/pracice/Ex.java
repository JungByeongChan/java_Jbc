package day7.pracice;

public class Ex {

	public static void main(String[] args) {
		/* 다음과 같이 출력되는 코드를 만드시오
		 * a
		 * ab
		 * abc
		 * abcd
		 * ....
		 * abcd...xyz
		 *  */
		
		 char ch;
		 		 
		 char end = 'a';
				 
		 while(end <= 'z') {
			 ch ='a';
			 while(ch <= end) {
				 System.out.print(ch);
				 ch++;
				 
			 }
			 System.out.println();
			 end++;
			 
			 
			 
		 }
		 /*
		 char ch = 'a', end;
		 for(end = 'a'; end <= 'z'; end++) {
			 for(ch = 'a'; ch <= end; ch++) {
				 System.out.print(ch);
			 }
			 System.out.println();
		 }
		 */
		 

	}

}
