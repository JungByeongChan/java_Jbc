package day28;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import day28.vo.Food;

public class FileSave {
	
	
	private Food food = new Food("사과", 20);
	

	public void eat() {

		String fileName = "src/day28/Food.txt";
		
		
		
		
		fileSave(fileName);
	}

	
	public void fileSave(String fileName){
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(food);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}


}	
