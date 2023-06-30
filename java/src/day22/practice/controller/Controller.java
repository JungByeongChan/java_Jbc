package day22.practice.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.vo.PhoneList;

public class Controller implements Program2{
	
	private Scanner sc = new Scanner(System.in);
	private final int Exit = 5;
	
	private ArrayList<PhoneList> list = new ArrayList<>();
	private List<PhoneList> list2 = new ArrayList<>();
	
	
	@Override
	public void printMenu() {
		System.out.println("===========");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 전화번호 삭제");
		System.out.println("5. 프로그램 종료");
		
	}

	@Override
	public void run() {
		int menu;
		do {
			try {
			printMenu();
			System.out.println("input number");
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("==========");
			}catch(InputMismatchException e) {
				menu = Exit-1; 
				sc.nextLine();
				System.out.println("Wriong Input!");
			}
			
			
			
			
		}while(menu != Exit);
		
		
	}

	@Override
	public void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			phoneNumberRegistration();
			break;
		case 2:
			modifyPhoneNumber();
			break;
		case 3:
			phoneNumberSearch();
			break;
		case 4:
			phoneNumberDeleat();
			break;
		case 5:
			break;
			default:
				System.out.println("wrong input");
		}
		
		
	}

	private void phoneNumberDeleat() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 이름을 입력 : ");
		String name = sc.nextLine();
		
		System.out.println("삭제할 번호 입력 :");
		sc.nextLine();
		String num = sc.nextLine();
		
		PhoneList phone = new PhoneList(name, num);
		int index = list.indexOf(phone);
		
		if(index == -1) {
			System.out.println("없는 이름");
			return;
		}
		if(list.remove(phone)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void phoneNumberSearch() {
		// TODO Auto-generated method stub
		
	}

	private void modifyPhoneNumber() {
		// 
		System.out.println("변경할 번호의 이름을 입력 : ");
		String name = sc.nextLine();
		
		PhoneList phone = new PhoneList(name, null);
		int index = list.indexOf(phone);
		
		if(index == -1) {
			System.out.println("없는 이름");
			return;
		}
		sc.nextLine();
		System.out.println("바꿀 번호를 입력");
		String num = sc.nextLine();
		phone = new PhoneList(name, num);
		if(list.contains(phone)) {
			System.out.println("등록 실패");
			return;
		}
		list.get(index).update(name, num);
		
		
		
		
		
	}
	public boolean insertPhone(String name, String phoneNumber) {
		PhoneList pn = new PhoneList(name, phoneNumber);
		if(pn.getPhoneNumber().length() == 0) {
			return false;
		}
		list2.add(pn);
		return true;
	}
	
	public void print(Predicate<PhoneList> p) {
		for(PhoneList pn : list2) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
	
	public boolean updateName(String name, String updateName) {
		//name과 일치하는 전화번호를 찾아야 함
		//전화번호부에 수정할 이름이 해당하는 전화번호가 어디에 있는지 확인
		int index = list2.indexOf(new PhoneList(updateName,""));
		//없으면 수정이 안됨 => 메서드를 종료
		if(index == -1) {
			return false;
		}
		//찾은 전화번호의 이름을 수정
		//전화번호부에서 이름과 일치하는 전화번호를 가져옴
		PhoneList pn = list2.get(index);
		//가져온 전화번호와 이름을 수정
		pn.setName(updateName);
		
		//list2.get(index).setName(updateName); <= 위의 코드2줄을 한줄로 정리하면 이렇게가능
		
		/*
		// 기본 자료형은 =을 이용하면 값을 복사하기 때문에 한쪽의 값이 바뀌어도 다른쪽은 바뀌지않는다.
		int num1 = 1; // num1 = 1
		int num2 = num1; // num1 = 1, num2 = 1
		num2 = 10;		// num1 = 1, num2 = 10
		//참조변수는 =을 이용하면 주소값을 복사하기 때문에 한쪽의 값이 바뀌면 다른쪽도 바뀜
		//Ex) pn1에 저장된 주소가 0x1000
		PhoneList pn1 = new PhoneList("a", "010-1234-5678");
		//pn1에 저장된 주소 : 0x1000, pn2에 저장된 주소 : 0x1000
		PhoneList pn2 = pn1;
		//0x1000번지에 있는 객체의 name을 Lim으로 수정
		pn2.setName("Lim");
		*/
		return true;
	}
	//전화번호 수정
	public boolean updateNumber(String name, String phoneNumber) {
		//name과 일치하는 전화번호부를 찾음
		int index = list2.indexOf(new PhoneList(name, ""));
		//일치하는 전화번호부가 없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//number가 전화번호 패턴이 맞는지 확인하기 위해서
		//전화번호 패턴이 맞으면 전홥너호 객체를 생성 했을 때 전화번호가 있고,
		//패턴이 맞지 않으면 빈 문자열이 있다.
		//name과 number를 이용하여 전화번호 객체를 생성하는 대신 checkNumber를 이용
		//number가 전화번호 패턴이면 전화번호룰 수정
		if(!PhoneList.checkNumber(phoneNumber)) {
			return false;
		}
		list2.get(index).setNumber(phoneNumber);
		return true;
	}
	
	public boolean update(String name, String updateName, String phoneNumber) {
		PhoneList pn = new PhoneList(name, phoneNumber);
		//name을 이용하여 전화번호부 검색
		int index = list2.indexOf(pn);
		//없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//number가 전화번호 패턴에 안맞으면 실패
		if(!PhoneList.checkNumber(phoneNumber)) {
			return false;
		}
		//기존에 있는 전화번호를 삭제
		list.remove(index);
		//updateName과 number를 이용하여 전화번호 객체를 생성한 후 추가
		list.add(pn);
		return true;
	}
	
	public boolean delete(String name) {
		//name으로 PhoneNumber 객체를 생성 후 삭제 요청
		return list.remove(new PhoneList(name, ""));
	}
	
	
	
	

	private void phoneNumberRegistration() {
		System.out.println("이름 입력 :");
		String name = sc.nextLine();
		System.out.println("번호 입력");
		sc.nextLine();
		String num = sc.nextLine();
		
		PhoneList phone = new PhoneList(name, num);
		if(!list.contains(phone)) {
			list.add(phone);
			System.out.println("등록 성공");
			return;
		}else {
			System.out.println("등록 실패");
		}
			
		
		
		
		
	}

}
