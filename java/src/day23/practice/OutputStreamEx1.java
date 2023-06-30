package day23.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStreamEx1 {
	//정수를 1~10까지 파일에 저장하는 코드를 작성하시오.
	public static void main(String[] args) {
		try(FileOutputStream fis = new FileOutputStream("output1.txt")){
			for(int i = 1; i<= 10; i++) {
				fis.write(i);
			}
			System.out.println("File write success!!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try(
			FileOutputStream fos = new FileOutputStream("output2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeChars("hello\n");
			for(int i = 1; i<= 10; i++) {
				oos.writeInt(i);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
