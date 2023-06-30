package day23.stream;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) {
		File file = new File("test");
		try {
			//해당 파일 또는 폴더가 존재하지 않고, 
			//이름에 .이 들어가면(확장자가 있으면) 파일을 생성
			if(!file.exists() && file.getName().contains(".")) {
				file.createNewFile();
				System.out.println("create file!");
			}
			//해당 파일/폴더가 존재하지 않고,
			//이름에 .이 들어가지않으면(확장자가 없으면) 폴더를 생성
			if(!file.exists() && !file.getName().contains(".")) {
				file.mkdir();
				System.out.println("create directory!");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//file.delete();

	}

}
