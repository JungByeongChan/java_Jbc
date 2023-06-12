package day9.classEx;

public class CarMain {

	public static void main(String[] args) {
		// 현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하시오.
		
		Car kendai = new Car("The new abante", "Hyundai", 2023);
		//현재 내차 정보를 조회
		kendai.turn();
		kendai.setGear('d');
		kendai.printInfo();
		kendai.speedChange(false);
		kendai.printInfo();
		
		kendai.speedChange(true);
		kendai.printInfo();
		kendai.speedChange(true);
		kendai.printInfo();
		
		kendai.speedChange(true);
		kendai.printInfo();
		
		kendai.speedChange(false);
		kendai.printInfo();
		
		
		
		

	}

}


