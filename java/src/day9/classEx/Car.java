package day9.classEx;

public class Car {
	//멤버 변수(필드)
	private String name; 		//차명
	private String company;		//제조사
	private int year;			//연식
	private int speed;			//속력
	private char gear;		//p:주차, R:후진, D:주행, N:중립
	private boolean power;		//전원
	
	//생성자
	public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'p';
		
	}
	//메서드
	/** 자동차 정보를 출력하는 메서드
	 * 매개변수 : 없음(이미 멤버변수들이 다 알고있음)
	 * 리턴타입 : Void
	 * 메서드명 : printInfo
	 * */
	public void printInfo() {
		System.out.println("자동차 조회");
		System.out.println("제조사 : " + company);
		System.out.println("모델 : " + name);
		System.out.println("연식 : " + year);
		System.out.println("전원 :" + (power? "on" : "off"));
		System.out.println("기어 : " + gear);
		System.out.println("속력 : " + speed);
	}
	/**
	 * 속력이 1 증가 또는 1 감소 메서드
	 * 매개변수 : 증가할건지 => boolean positive(증가하면 true / 감소하면 false)
	 * 리턴타입 : void(없음)
	 * 메서드명 : speedChange
	 */
	public void speedChange(boolean positive) {
		//전원이 꺼져있으면 종료
		if(!power) {//ture가 아니면 false이면//
			return;
		}
		//기어가 중립 또는 주차중이면 종료
		if(gear == 'n' || gear =='p') {
			return;
		}
		//속력이 증가하는 경우이면
		if(positive) {
			speed += 1;
		}//속력이 감소하는 경우이고, 속력이 0보다 크면(차의 속도는 -가 될수 없기때문)
		else if(speed > 0){
			speed -= 1;
		}
	}
	/**
	 * 자동차 시동을 켜거나 끄는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : turn
	 */
	public void turn() {
		//시동이 꺼져있으면 킴
		if(!power) {
			power = true;
		}else if(gear == 'p') {
			power = false;
		}
	}
	public void setGear(char _gear) {
		gear = _gear;
	}
	
	
	
}
