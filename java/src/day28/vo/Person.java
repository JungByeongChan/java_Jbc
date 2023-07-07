package day28.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class Person {
	
	
	private String name;
	
	private String sad;
	
	

	public Person(String name, String sad) {
		
		this.name = name;
		this.sad = sad;
	}
	
	
	
	
}
