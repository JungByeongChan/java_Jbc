package day22.practice.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

@Data
public class PhoneList {

	private String phoneNumber;
	private String name;
	
	//전화번호가 010-xxxx-xxxx 패턴이 맞는지 확인해주는 메서드
	//외부에서도 객체생성 없이 쓸 수 있게 static과 public을 붙여줌 // static이 붙으면 객체생성 없이 이용가능
	public static boolean checkNumber(String num) {
		String regex = "^010(-\\d{4}){2}&";
		return Pattern.matches(regex, num);
	}
	
	
	public PhoneList(String name, String phoneNumber) {
		if(checkNumber(phoneNumber)) {
		this.phoneNumber = phoneNumber;
		};
		this.phoneNumber = checkNumber(phoneNumber)?phoneNumber:"";
		this.name = name;
	}
	
	
	public void setNumber(String phoneNumber) {
		this.phoneNumber = checkNumber(phoneNumber)?phoneNumber:this.phoneNumber;
	}

	public void update(String name, String phoneNumber) {
		// TODO Auto-generated method stub
		if(checkNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
			};
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneList other = (PhoneList) obj;
		return Objects.equals(name, other.name);
	}
	
	

	
}
