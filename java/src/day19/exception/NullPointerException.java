package day19.exception;

public class NullPointerException {

	public static void main(String[] args) {
		/*
		 * NullPointerException
		 * => 객체가 null인 상태로 메서드, 멤버를 호출하는 경우 발생
		 */
		
		
		String str = null;//NullPointerException 오류, RuntimeException 오류임
		//String str ="abc";
		//System.out.println(str.substring(0));
		test(str);//메서드를 활용하면 빨간줄이 안뜨기때문에 실수하기가 쉬움. 따라서 예외처리가 필요함

	}
	//메서드로 만들때는 반드시 예외처리를 해주는 편이 좋다. 매개변수의 null체크를 반드시 하는게 좋다.
	public static void test(String str) {
		if(str == null) {
			return;
		}
		System.out.println(str.substring(0));
	}

}
