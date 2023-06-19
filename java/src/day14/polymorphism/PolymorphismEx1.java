package day14.polymorphism;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		// 매개변수의 다형성
		// 리모컨으로 여러 제품의 전원을 켜는 예제
		// 제품 : TV, 에어컨, 라디오
		// 리보컨 클래스, 에어컨 클래스, 라디오 클래스
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		AirConditioner aircon = new AirConditioner();
		RemoteControl remocon = new RemoteControl();
		
		remocon.turnOn(tv1);//TV를 켜는 기능
		remocon.turnOn(aircon);// 에어큰을 켜는 기능
		remocon.turnOn(radio1);// 라디오를 켜는 기능
		System.out.println("===============");
		
		//매개변수의 다형성을 이용
		TV1 tv2 = new TV1();
		Radio1 radio2 = new Radio1();
		AirConditioner1 aircon1 = new AirConditioner1();
		RemoteControl1 remocon1 = new RemoteControl1();
		
		
		HomeAppliances appliance = tv2;//업캐스팅
		remocon1.turnOff(appliance);
		
		remocon1.turnOn(tv2); // 가전을 켜는기능
		remocon1.turnOn(aircon1);// 가전을 켜는기능
		remocon1.turnOn(radio2);// 가전을 켜는기능
		System.out.println("==============");
		remocon1.turnOff(aircon1);
		remocon1.turnOff(radio2);
		remocon1.turnOff(tv2);
		
	}

}
class RemoteControl{
	public void turnOn(TV tv) {
		tv.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn(AirConditioner aircon) {
		aircon.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOn(Radio radio) {
		radio.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
}
class TV{
	boolean power;
	int channel;
	void turnOn() {
		power = true;
	}
}
class AirConditioner{
	boolean power;
	double CurrentTemperature;//현재온도
	double desiredTemperature;//희망온도
	void turnOn() {
		power = true;
	}
}
class Radio{
	boolean power;
	double frequency;
	void turnOn() {
		power = true;
	}
}









class HomeAppliances{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}


class RemoteControl1 {
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(HomeAppliances appliances) {
		appliances.turnOff();
		System.out.println("전원이 꺼졋습니다.");
	}
	
}
class TV1 extends HomeAppliances {
	int channel;
	
}
class AirConditioner1 extends HomeAppliances{
	
	double CurrentTemperature;//현재온도
	double desiredTemperature;//희망온도



}
class Radio1 extends HomeAppliances{
	
	double frequency;
	
	
	
}