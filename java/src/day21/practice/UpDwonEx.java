package day21.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UpDwonEx {

	public static void main(String[] args) {
		//
/*
		UpDeown 프로그램을 작성하고, 기록도 관리하는 기능을 추가하세요.
		1. play
		2. recod
		3. exit
		sedlec : 1
		record id id abc:
 	*/
		Scanner sc = new Scanner(System.in);
		int menu;
		
		do {
			menuPrint();
			menu = sc.nextInt();
			runMenu(menu);
			
			
		}while(menu != 3);
			
		
		
		
	}
	public static void menuPrint() {
		System.out.println("==========");
		System.out.println("1. play");
		System.out.println("2. record");
		System.out.println("3. exit");
	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1: 
			play();
			break;
		case 2:
			recoad();
			break;
		case 3:
			break;
			default:
				System.out.println("Wrong input!");
		}
	}
	
	public static void play() {
		int min =1, max =10;
		int user;
		int random = (int)(Math.random()*(max - min + 1)+min);
		Scanner sc = new Scanner(System.in);
		System.out.println(random);
		System.out.println("input number");
		
		do{
			user = sc.nextInt();
			if(user<random) {
			System.out.println("up!");
			}else {
				System.out.println("down!");
			}
		}while(user != random);
		System.out.println("good!");
		
	}
	private static void recoad() {
		HashMap<String, Integer> user = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		
	}
	

}

