package day17.practice.vo;

import lombok.Data;

@Data
public class Customer {
	private String customerId;//고객이 추가되면 자동으로 발급
	private String name;
	private String phoneNumber;
	
	//고객 ID 발급을 위한 클래스 변수
	//등록된 고객 수
	private static int count;
	//고객 아이디 앞부분
	private final static String CID = "CID";
	//고객 아이디 뒷부분 숫자의 최대 길이
	private final static int MAX_SIZE = 5;
	
	//생성자
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId();//CustomerID를 생성하는 메서드 // customerId 발급이 완료
	}

	public Customer(Customer customer) {
		this.name = customer.name;
		this.phoneNumber = customer.phoneNumber;
		this.customerId = customer.customerId;
	}

	private void generateCustomerId() { // 밖에서 쓸일이 아예 없기 때문에 private를 사용해도됨
		//1 => 00001
		//1 => "1"
		String num = "" + ++count;// 문자열로 만들기 위해 공백을 넣어줌
		//"1".length == 1 / 5개중에 1을 뺀 나머지 4개를 0으로 채우면됨
		int length = num.length();
		for(int i = 0; i < MAX_SIZE - length; i++) {
			//A = A+B; A+=B 
			num = "0" + num; // 문자열이기때문에 +=을 쓸수가 없음 
		}
		
		customerId = CID + num;
		
	}
	
	public void print() {
		System.out.println("고객번호 : " + customerId);
		System.out.println("고객이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}
