package day27.iostream.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;
@Data
public class Attendance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5556008685205440940L;
	private Date date;//출석날짜
	private Student student;//학생정보
	private boolean attendance;
	
	
	public void attendance() {
		this.attendance = true;
	}
	
	public void absent() {
		this.attendance = false;
	}

	public Attendance(Date date, Student student, char state) {
	
		this.date = date;
		this.student = student;
		this.attendance = state == '0' ? true : false;
	}

	@Override
	public String toString() {
		return student.toString() + " : " + (attendance ? " O " : "X" );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(date, other.date) && Objects.equals(student, other.student);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, student);
	}

	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		return format.format(date);
	}
	
	
	
	
	
	

}
