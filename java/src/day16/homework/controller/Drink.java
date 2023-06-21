package day16.homework.controller;

import lombok.Data;

@Data
public class Drink {

	private String Fanta;
	private String Sprite;
	private String Coke;
	
	public Drink(String fanta, String sprite, String coke) {
		
		Fanta = fanta;
		Sprite = sprite;
		Coke = coke;
	}
	
	
	
	
	
	
}
