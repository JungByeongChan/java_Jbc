package day22.practice.vo;

import java.util.Objects;

public class PhoneList {

	int phoneNumber;
	String name;
	
	public PhoneList(String name, int phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public void update(String name, int num) {
		// TODO Auto-generated method stub
		this.phoneNumber = num;
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
