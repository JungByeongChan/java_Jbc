package day28.vo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1972067225907919388L;
	private String name;
	private int kcal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public Food(String name, int kcal) {
		
		this.name = name;
		this.kcal = kcal;
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", kcal=" + kcal + "]";
	}
	
	
	
	
	
}
