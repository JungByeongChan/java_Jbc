package day27.iostream.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2893699603675246935L;
	private String name;
	private String num;
	
	public Student(String name, String num) {
		
		this.name = name;
		this.num = num;
		
	}
	//복사 생성자
	public Student(Student tmp) {
		this(tmp.name, tmp.num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return num == other.num ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public String toString() {
		return num + " " + name;
	}
	
	
	
	
	
}
