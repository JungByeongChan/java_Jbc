package day7.pracice;

public class PrintAlphabetEx {

	public static void main(String[] args) {
		// a부터 z까지 출력하는 코드를 작성하시오. abcd....xyz
		
		char Alp = 97;
		char ch = 'a';
		int i;
		while(Alp <= 122) {
			System.out.print(Alp);
			Alp++;
				
				
			}
			
		System.out.println("\n" + "=========================");
		
		for(i = 0; i <26; i++) {
			System.out.print((char)(ch+i));
		}
		System.out.println("\n" + "=========================");
		for(ch = 'a'; ch<= 'z'; ch++) {
			System.out.print(ch);
		}
	
		

	}
}


