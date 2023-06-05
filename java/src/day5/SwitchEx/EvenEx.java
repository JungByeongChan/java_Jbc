package day5.SwitchEx;

public class EvenEx {

	public static void main(String[] args) {
		// 홀짝 예제를 switch문으로
		// switch 문에는 조건식이 올 수가 없음
		int num = 4;
		// num을 2로 나눈 나머지 값을 활용
		switch(num % 2) {
		case 0:
			System.out.println(num + " is a even number.");
			break;
		default :
			System.out.println(num + " is a odd number.");
		}

	}

}
