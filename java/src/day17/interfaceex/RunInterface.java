package day17.interfaceex;

public interface RunInterface{
	/*public abstract*/ void run();// public abstract가 자동으로 들어가기때문에 생략가능
	//추상메서드이기 때문에 구현부가 없다.
	int num = 10;//public final static이 자동으로 들어가기 때문에 상수를 선언해야함
	//클래스 상수 => 클래스를 이용하여 호출
	default void stop() {
		System.out.println("Program stop!");
		
	}
}