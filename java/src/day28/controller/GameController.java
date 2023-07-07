package day28.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import day27.iostream.vo.AttendanceBook;
import day28.vo.BaseballGame;
import day28.vo.Record;

public class GameController {

	private Scanner sc = new Scanner(System.in);
	private BaseballGame bbGame;
	private List<Record> recordList = new ArrayList<>();
	public void run() {
		int menu;
		String fileName = "baseball.txt";
		load(fileName);
		do {
			
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
				
			
		}while(menu != 3);
		save(fileName);
		
		
		
	}

	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(recordList);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				recordList = (List<Record>) ois.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("List<Record> 클래스를 찾을 수 없습니다.");
			} 
	}

	private void printMenu() {
		// 
		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. Exit");
		System.out.println("Select : ");
		
	}
	private void runMenu(int menu) {
		// 
		switch(menu) {
		case 1:
			play();
			break;
		case 2:
			recordGame();
			break;
		case 3:
			break;
			default:
				System.out.println("Wrong input!");
		}
		
	}

	private void play() {
		//랜덤 수 생성
		bbGame = new BaseballGame();
		List<Integer> user = new ArrayList<>();
		int count = 0;
		//맞출때까지 반복
		do {
			//사용자가 입력
			System.out.println("user :");
			for(int i=0;i<3;i++) {
				user.add(sc.nextInt());
			}
			//입력한 값을 게임에 넣어줌, 입력한 값이 중복되거나 범위가 넘어가면 알림창을 출력
			if(bbGame.setUser(user)) {
				System.out.println("중복되거나 범위를 벗어나는 값을 입력");
				continue;
			}
			//결과 출력
			bbGame.printResult();
			user.clear();
			count++;
		}while(bbGame.getStrike() != 3);
		//기록 관리자(개수제한X)
		System.out.println("이름을 입력 : ");
		String name = sc.next();
		Record record = new Record(name, count);
		recordList.add(record);
		
		
	}

	private void recordGame() {
		// 
		Collections.sort(recordList, (o1,o2) -> {
			return o1.getCount() - o2.getCount();
		});
		recordList.stream().forEach(r->System.out.println(r));
		
	}
}
