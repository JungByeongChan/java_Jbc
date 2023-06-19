package day13.homework.controller;

import java.util.Scanner;

import day13.homework.VocabularyNote;

public class VocabularyNoteController {
	
	private Scanner sc= new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	
	
	public void run() {
		//반복(종료를 선택하기전까지) => 무조건 1번은 실행
		int menu = -1;
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//메뉴에 다른 기능 실행
			runMenu(menu);
			
		}while(menu != 5);
		sc.close();
	}
	/**
	 * 메뉴에 따른 기능을 실행하는 메서드
	 * 매개변수 : 메뉴 => int menu
	 * 리턴타입 : 없음 => void
	 * 메서드명 : runMenu 
	 */
	private void runMenu(int menu) {
		switch(menu) {
			//메뉴가 1이면 단어 추가 기능을 실행
		case 1:
			System.out.println("===========");
			insertWord();
			System.out.println("============");
			break;
			//메뉴가 2이면 단어 삭제 기능을 실행
		case 2:
			System.out.println("===========");
			deleteWord();
			System.out.println("============");	
			break;
			//메뉴가 3이면 단어 수정 기능을 실행
		case 3:
			System.out.println("===========");
			updateWord();
			System.out.println("============");	
			break;
			//메뉴가 4이면 단어 출력 기능을 실행
		case 4:
			System.out.println("===========");
			printWord();
			System.out.println("============");	
			break;
			//메뉴가 5이면 프로그램을 종료
		case 5:
			System.out.println("===========");
			System.out.println("Exit the program");
			System.out.println("============");	
			break;
			//메뉴가 그외이면 잘못된 메뉴라고 출력
			default:
			System.out.println("wrong input");
		}
				
	}
	
	private void insertWord() {
		//추가할 단어를 입력
		System.out.println("Word : ");
		String title = sc.next();
		
		//단어에서 입력한 엔터를 처리
		sc.nextLine();
		//추가할 뜻을 입력
		System.out.print("mean : ");
		String meaning = sc.nextLine();
		
		//단어장에 추가
		int result = note.insert(title, meaning);
		
		switch(result) {//result를 없애고 note.insert(title, meaning); 를바로 넣어도됨
		case 1: System.out.println("add word Success"); break;
		case -1: System.out.println("add mean Success"); break;
		case 0: System.out.println("add word false"); break;
		}
		
	}
	/**
	 * 메뉴를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void 
	 * 메서드명 : printMenu
	 */
	private void printMenu() {
		System.out.println("menu");
		System.out.println("1. Add a word");
		System.out.println("2. Delete a word");
		System.out.println("3. word modification");
		System.out.println("4. Word Output");
		System.out.println("5. Exit the program");
		System.out.print("Select a menu : ");
	}
	
	
	private void printWord() {
		//서브메뉴 출력
		printSubMenuPrint();
		//서브메뉴 선택
		int submenu = sc.nextInt();
		switch(submenu) {
		case 1: 	//서브메뉴가 1이면 전체 출력
			note.print();
			break;
			
		case 2: 	//서브메뉴가 2이면 검색
			//검색할 단어
			System.out.println("Word Search : ");
			String title = sc.next();
			
			//출력
			note.search(title);
			break;
		}
	
		
		
	}
	private void printSubMenuPrint() {
		System.out.println("===========");
		System.out.println("SubMenu");
		System.out.println("1.Overall Output");
		System.out.println("2. Word Search");
		System.out.println("Select a submenu");
	}
	private void deleteWord() {
		//삭제할 단어 입력
		System.out.println("What Delete Word? : ");
		String title = sc.next();
				
		//해당 단어 삭제
		
		if(note.delete(title)) {
			System.out.println("Success word delete");
		}else {
			System.out.println("false word delete");
		}
	}
	private void updateWord() {
		//서브메뉴 출력
		printSubMenuUpdate();
		//서브메뉴 입력
		int submenu = sc.nextInt();
			
		//서브 메뉴에 따른 기능 실행
		switch(submenu) {
				
		case 1: //단어 수정
			//수정할 단어
			System.out.println("What word modification? :");
			String word = sc.next();
			//수정될 단어
			System.out.println("Words to be modified :");
			String updateWord = sc.next();
			//단어장에 있는 단어 수정기능을 실행
			if(note.updateTitle(word, updateWord)) {
				System.out.println("success Word");
			}else {
				System.out.println("false Word");
			}
			
			break;
				
		case 2: //뜻 수정
			//뜻을 수정할 단어를 입력
			System.out.println("Please enter the word you want to modify :");
			String title = sc.next();
			//단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title)) {
				System.out.println("nothint Word");
				return;
			}
			
			//수정할 뜻의 번호를 입력
			System.out.println("Select the meaning number to modify :");
			int num = sc.nextInt();
			
			sc.nextLine();//엔터처리 하는것(뜻은 공백처리까지 하기때문 newLine 전에는 항상 해줘야함)
			//수정될 뜻을 입력
			System.out.println("Meaning to modify :");
			String meaning = sc.nextLine();
			//단어장에서 수정
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("false word modify");
			}else {
				System.out.println("success word modify");
			}
			
			break;
				
		case 3: //뜻 삭제
			//뜻을 삭제할 단어를 입력
			System.out.println("Please enter the word you want to delete :");
			String title2 = sc.next();
			//단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title2)) {
				System.out.println("nothint Word");
				return;
			}
			
			//수정할 뜻의 번호를 입력
			System.out.println("Select the meaning number to delete :");
			int num2 = sc.nextInt();
			if(!note.deleteManing(title2, num2)) {
				System.out.println("false mean");
			}else {
				System.out.println("Success mean");
			}
			
			
			break;
		}
	}
	private void printSubMenuUpdate() {
		System.out.println("submenu");
		System.out.println("1. word modification");
		System.out.println("2. mean modification");
		System.out.println("3. mean delete");
		System.out.println("4. select a submenu");
		
	}
	
	
}
