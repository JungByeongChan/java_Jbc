package day8.method;

public class MethodCallstackEx {

	public static void main(String[] args) {
		// 함수(메서드) 호출 스택 예제
		method1(1);

	}
	
	public static void method1(int a) {
		System.out.println(a);
		method2(a);
		
	}
	public static void method2(int a) {
		System.out.println(a-1);
		method3();
		
	}
	public static void method3() {
		System.out.println("end");
	}
	public static void method4() {
		System.out.println("a");
		method4();
		// 자기자신을 계속해서 호출하기때문에 무한루프가 일어나다가 스택이 꽉차버려서 StackOverFlow오류가발생함
		// 재귀(자기 자신을 호출 하는것) 메서드라고 지칭
	}

}
