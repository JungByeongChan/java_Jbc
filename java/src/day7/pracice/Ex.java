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
		 
		 char ch1 = 'a', end1;
		 for(end1 = 'a'; end1 <= 'z'; end1++) {
			 for(ch1 = 'a'; ch1 <= end1; ch1++) {
				 System.out.print(ch1);
			 }
			 System.out.println();
		 }
		 
		 

	}

}
