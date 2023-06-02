package day4.If_Ex;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 양수이면 positive number라고 출력하고
		 * num가 음수이면 negative numer로 출력하고
		 * num가 0이면 0으로 출력하는 코드를 작성하시오.
		 * 	 */
		
		int num;
		num = 3;
		if(num > 0) {
			System.out.println(num + " is a positive numer");
		}
		else if(num < 0) {
			System.out.println(num + " is a negative numer");
		}
		else {
			System.out.println(num + " is a 0");
		}
		
		
		

	}

}
