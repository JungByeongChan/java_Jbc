package day25.test.student.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import day25.test.student.vo.Student2;

public class Controller2 {
	

	private ArrayList<Student2> list = new ArrayList<>();
	Student2 tmp;
	

	final private int Exit = 3;
	Scanner sc = new Scanner(System.in);
	

	public void run() {
		int user;
		String fileName = "src/day25/test/student/student.txt";
		load(fileName);
		
		do {
			runMenu();
			System.out.println("이용할 메뉴의 번호를 입력하시오 :");
			user = sc.nextInt();
			mainMenu(user);
			
		}while(user != Exit);
		save(fileName);
	}


	private void save(String fileName) {
		//학생 정보를 저장 => List => 하나씩 꺼내서 저장
		//저장 OutputStream
		//객체단위로 저장 => ObjectOutputStream
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Student2 tmp : list) {
					oos.writeObject(tmp);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}


	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				while(true) {
					Student2 tmp = (Student2)ois.readObject();
					list.add(tmp);
				}
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				//ObjectInputStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable 인터페이스를 구현하지 않으면 발생
				System.out.println("Student 클래스를 찾을수 없습니다.");
			} 
		
	}


	private void mainMenu(int user) {
		switch(user) {
			case 1:
				insertStudent();
				break;
			case 2:
				searchStudent();
				break;
			case 3:
				System.out.println("종료");
				break;
				
				
		}
	}


	private void searchStudent() {
		
		
			for(Student2 tmp : list) {
				System.out.println(tmp.toString());
			}
		
			
		
		
		
	}


	private void insertStudent() {
		
		System.out.println("등록할 학번을 입력하시오");
		int grade = sc.nextInt();
		System.out.println("등록할 과를 입력하시오");
		sc.nextLine();
		String Subject = sc.nextLine();
		System.out.println("등록할 이름을 입력하시오");
		String name = sc.nextLine();
		
		
		Student2 tmp = new Student2(grade, name, Subject);
		list.add(tmp);
		System.out.println("등록 완료");
		System.out.println(tmp);
		
	}


	private void runMenu() {
		System.out.println("============");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 확인");
		System.out.println("3. 종료");
		
	}
	
	
	
	
}
