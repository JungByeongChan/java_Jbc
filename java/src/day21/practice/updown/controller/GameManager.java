package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import day21.practice.updown.vo.RecordGame;

public class GameManager implements Program{
	//리터럴 3에 이름을 붙여서 명확하게 전달하기 위함
	private static final int Exit = 3;
	//다른 메서드에서 매번 객체를 생성하는 것이 번거롭기때문
	private Scanner sc = new Scanner(System.in);
	//기록을 저장하는 리스트
	private ArrayList<RecordGame> list = new ArrayList<>();

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("==========");
		System.out.println("1. play");
		System.out.println("2. record");
		System.out.println("3. exit");
	}

	@Override
	public void run() {
		System.out.println("program start");
		int menu;
				
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
			
		}while(menu != 3);
	
	}

	@Override
	public void runMenu(int menu) {
		// TODO Auto-generated method stub
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
	
	public void play() {
		int min =1, max =10;
		int user;
		int random = (int)(Math.random()*(max - min + 1)+min);
		Scanner sc = new Scanner(System.in);
		System.out.println(random);
		System.out.println("input number");
		int count = 0;
		do{
			user = sc.nextInt();
			if(user<random) {
			System.out.println("up!");
			}else if(user > random){
				System.out.println("down!");
			}else {
				System.out.println("good!");
			}
			count++;
		}while(user != random);
		
		System.out.println("Record ID :");
		String id = sc.next();
		
		RecordGame rec = new RecordGame(id, count);
		list.add(rec);
		//sort();
		list.sort(new Comparator<RecordGame>() {

			@Override
			public int compare(RecordGame o1, RecordGame o2) {
				
				return o1.getCount() - o2.getCount();
			}
		});
	}
	private void sort() {
		for(int i = 0; i<list.size() -1 ; i++) {
			for(int j = 0 ; j < list.size() - 1 ; j++) {
				if(list.get(j).getCount()>list.get(i).getCount()) {
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
	}
	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
	}
	
	public static void sort(ArrayList<RecordGame> list) {
		
	}

}
