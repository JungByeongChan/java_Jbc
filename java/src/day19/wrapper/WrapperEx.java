package day19.wrapper;

public class WrapperEx {

	public static void main(String[] args) {
		// 
		Integer num1 = 10; // 박싱 : 정수 10을 Integer 클래스 객체 num에 저장
		//num1 = null;
		int num2 = 0;
		if(num1 != null) {
			num2 = num1; // 언박싱 : Integer 클래슬 객체 num1에 있는 값을 num2에 저장 // 예외처리 필요
		}// 경고줄은 뜨지면 정상적으로 실행은 됨
		
		System.out.println(num1);
		System.out.println(num2);
		
		//ArrayList<Integer> list; // <> 꺽새는 제네릭 클래스를 의미 / 안에 무조건 래퍼클래스가 들어가야함
		
		//Integer.parseInt와 같은 문자열을 기본자료형으로 변호나하는 메서드를 사용할 때 예외처리 해주는 것이 좋음
		int num3 = Integer.parseInt("123");
		System.out.println(num3);
	}

}
