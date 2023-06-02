package day4.If_Ex;

public class EvenNumnerEx {

	public static void main(String[] args) {
		// if else문을 이용한 홀짝 판별 예제
		// num가 짝수이면 짝수라고 출력하고 아니면 홀수라고 출력해라
		int num = 4;
		if(num % 2 == 0) {
			System.out.println(num + " is a even number.");
		}else {
			System.out.println(num + " is a odd number");
		}

	}

}
