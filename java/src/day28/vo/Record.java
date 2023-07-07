package day28.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1829841556349299384L;
	private String name;
	private int count;
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
	
	
	
}
