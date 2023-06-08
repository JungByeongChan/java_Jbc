package day7.pracice;

public class PrintEx {

	public static void main(String[] args) {
		// 원하는 값을 출력한 후 엔터까지 입력
		System.out.println("abc");
		System.out.println("ab");
		// 원하는 값을 출력(엔터가 안들어감)
		System.out.print("abc");
		System.out.print("ab");
		// 문자열 형태로 만들어서 출력, 서식 문자를 이용
		System.out.printf("String : %s\n", "abc");
		System.out.printf("Integer : %d\n", 1);
		System.out.printf("Char : %c\n", 'a');
		System.out.printf("double : %.2f\n", 3.12345678978);
		// .2 때문에 소수점 두번째 자리까지만 나옴

	}

}
