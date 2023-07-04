package day25.test.student.vo;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Data;

@Data
public class Student {

	private int grade;
	private String name;
	private String Subject;
	
	@Override
	public int hashCode() {
		return Objects.hash(Subject, grade, name);
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
		return Objects.equals(Subject, other.Subject) && grade == other.grade && Objects.equals(name, other.name);
	}

	public Student(int grade, String name, String subject) {
		this.grade = grade;
		this.name = name;
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", name=" + name + ", Subject=" + Subject + "]";
	}
	
	
	
	
	
	
	
	
	
}
