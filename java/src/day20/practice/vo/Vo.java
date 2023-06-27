package day20.practice.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vo {

	
	private int grade, classNum, num;
	private String name;
	
	
	public void print() {
		System.out.println("학년 :" + grade);
		System.out.println("반 : " + classNum);
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vo other = (Vo) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}

	public void update(int grade, int classNum, int num, String name) {
		
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		
	}
	
	
}
