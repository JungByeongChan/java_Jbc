package day27.iostream.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day27.iostream.vo.Attendance;
import day27.iostream.vo.AttendanceBook;
import day27.iostream.vo.Student;

public class Controller {
	
	Scanner sc = new Scanner(System.in);
	
	private final int Exit = 4;
	
	private AttendanceBook book = new AttendanceBook();

	
	
	public void run() {
		int user;
		do {
			String fileName = "src/day27/iostream/attendancebook.txt";
			load(fileName);
			runMenu();
			user = sc.nextInt();
			mainMenu(user);
			
			save(fileName);
			
		}while(user != Exit);
		
	}


	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(book);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}


	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				book = (AttendanceBook)ois.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("AttendanceBook 클래스를 찾을 수 없습니다.");
			} 
	}


	private void mainMenu(int user) {
		switch(user) {
		case 1:
			insertStudent();
			break;
		case 2:
			attendance();
			break;
		case 3:
			attendanceBook();
			break;
		case 4:
			System.out.println("finish");
			break;
		default :
			System.out.println("Wrong Input!");
		}
		
			
		
		
	}

	private void attendanceBook() {
		// 출석부에 있는 모든 출석 정보를 확인
		book.printAttendance();
		
	}

	private void attendance() {
		//날짜 입력
		System.out.println("날짜 yyyy-mm-dd : ");
		String dateStr = sc.next();
		//날짜가 제대로 입력됐는지 체크
		//SimpleDateFormat을 이용
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("날짜 형식이 아닙니다.");
			return;
		}
		//출석부에서 학생 정보들을 가져와서 저장
		//=>AttendanceBook에 학생정보들을 가져오도록 추가 작업
		List<Student> stdList = book.getStdList();
		//반복문
		for(Student tmp : stdList) {
			//학생 정보를 출력
			System.out.println(tmp + " : ");
			//학생 출결을 입력 O or X
			char state;
			
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');
			//출석부에 체크
			//학생정보, 출결을 이용하여 출석 객체를 생성
		
			//출석부에 출석 객체를 추가
			//AttendanceBook에 출석 객체가 주어지면 출석 명단에 추가하는 작업
		
			Attendance attendance = new Attendance(date, new Student(tmp), state);
			
			if(!book.insertAttendance(attendance)){
				System.out.println("이미 등록된 출석");
			}else {
				System.out.println("출석체크 완료");
			}
			System.out.println(book.getList());
		}
		
	}

	private void insertStudent() {
		
		System.out.println("입력할 학생의 학년 : ");
		String num = sc.next();
		sc.nextLine();
		System.out.println("입력할 학생의 이름 : ");
		String name = sc.nextLine();
		
		Student std = new Student(num, name);
		boolean insertSuccess = book.insertStudent(std);
		System.out.println("=========");
		System.out.println(insertSuccess ? "학생정보 추가 성공!" : "학생 정보 추가 실패!");
		
		
		
		
	}

	private void runMenu() {
		System.out.println("============");
		System.out.println("1. insertStudent");
		System.out.println("2. attendance");
		System.out.println("3. attendanceBook");
		System.out.println("4. finish");
	}
	
	
	
	
	
	

}
