package day19.exception;

public class ExceptionEx1 {

	public static void main(String[] args) {
		//num2의 값이 0이어도 오류가 표시되지않음
		//허나, 예외가 발생해서 프로그램이 중단(ArithmeticException이 발생)
		//ArithmeticException은 RuntimeException의 자식클래스임으로 예외처리를 하지않아도 됨
		//코드상으로 오류가 표시되지 않지만 의도치 않게 프로그램이 중단되는 경우
		//코드상으로 오류 표시가 안되기 때문에 예외처리를 안하면 프로그램이 불안정
		//=>RuntimeException(실행오류)
		
		/*
		 * 대표적인 RuntimeException 클래스 // 기억해두는편이 좋다.
		NullPointerException  // String 에서 일어나는 경우
		ArrayIndexOutOfBoundsException // 배열 번지를 잘못 입력한 경우
		NumberFormatException
		ClassCastException // 상속관계인 관계에서 형변환(다운캐스팅) 할때 발생하는 오류
		ArithmeticException // 0으로 나눌 경우 
		 */
		int num1 = 1, num2 = 0;
		
		System.out.println(num1/num2);

	}

}
class A implements Cloneable{
	//clone 메서드를 오버라이딩 하기 위해서 Object 클래스의 clone을 호출하면
	//CloneNotSuppertedExcetion이 발생할 수 있다.
	//CloneNotSuppertedExcetion는 RuntimeException 클래스의 자식 클래스가 아님
	//=> 반드시 예외처리를 해야함
	//=> RuntimeException의 자식클래스가 아닌 경우들은 필수로 예외처리를 해야함
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}