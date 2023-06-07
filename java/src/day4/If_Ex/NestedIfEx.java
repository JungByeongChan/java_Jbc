package day4.If_Ex;

public class NestedIfEx {

	public static void main(String[] args) {
		/*
		 * 2,3,6의 배수 판별 예제
		 * (Day4.practice패키지에 IfMultipleEx2 문제)
		if(A % 6 == 0) {
			System.out.println(A + " = " + "" + "multiple of 6");
		}else if(A % 2 == 0) {
			System.out.println(A + " = " + "" + "multiple of 2");
		}else if(A % 3 == 0) {
			System.out.println(A + " = " + "" + "multiple of 3");
		}
		else {
			System.out.println(A + " = " + "" + "not multiple of 2,3,6");
		}
		*/
		int num = 5;
		
		//2의 배수
		if(num % 2 == 0) {
			//2의 배수 안에서 3의 배수를 찾는 것 ==> 6의 배수
			if(num % 3 == 0) {
				System.out.println(num + " = " + "" + "multiple of 6");
			}else {
				System.out.println(num + " = " + "" + "multiple of 2");
			}
			//2의 배수 안에서 3의 배수가 아닌 수 ==> 2의 배수
		}
		//3의 배수
		else if(num % 3 == 0) {
			System.out.println(num + " = " + "" + "multiple of 3");
		}
		//아닌 수
		else {
			System.out.println(num + " = " + "" + "not multiple of 2,3,6");
		}

	}

}
