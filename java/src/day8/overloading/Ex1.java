package day8.overloading;

public class Ex1 {

	public static void main(String[] args) {
		//println 의 메서드 오버로딩
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.1);
		System.out.println('c');
		
		System.out.println(sum(1,1));
		System.out.println(sum(1.1,1));
		System.out.println(sum(1,1.1));
		System.out.println(sum(1.1,1.1));
		
		System.out.println(sum(1,2,3));

	}
	
	public static int sum(int num1, int num2) {
		return num1 + num2;
		
	}// 아래 3개는 매개변수의 타입이 다른 경우
	public static double sum(double num1, int num2) {
		return num1 + num2;
	}
	public static double sum(int num1, double num2) {
		return num1 + num2;
	}
	public static double sum(double num1, double num2) {
		// 상위 메서드들의 기능을 다 포함하고있어 이것만 사용해도 가능
		return num1 + num2;
	}
	/*
		리턴 타입만 다른 메서드는 오버로딩이 될 수 없다.
	public static double sum(int num1, int num2) {
		return num1 + num2;
		
	}
	*/
	// 매개 변수의 개수가 다른경우
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
		
	}

}
