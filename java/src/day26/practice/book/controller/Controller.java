package day26.practice.book.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.practice.book.vo.Book;
import day26.practice.book.vo.LoanBrowsing;

public class Controller {
	
	private Scanner sc = new Scanner(System.in);
	private final int Exit = 4;
	List<Book> bookList = new ArrayList<>();
	
	List<LoanBrowsing> loanList = new ArrayList<>();
	
	
	public void run() {
		int user;
		String bookFileName = "src/day26/practice/book.txt";
		String loanFileName = "src/day26/practice/loan.txt";
		load(bookFileName);
		load(loanFileName);
		
		do {
			runMenu();
			System.out.println("이용할 메뉴의 번호를 입력하시오 :");
			user = sc.nextInt();
			mainMenu(user);
			
		}while(user != Exit);
		save(bookFileName);
		save(loanFileName);
	}


	

	private void insertBook() {
		sc.nextLine();//이전에 입력한 엔터 처리
		//도서 정보 입력
		System.out.println("등록할 책의 제목 :");
		String title = sc.nextLine();
		System.out.println("등록할 책의 저자 : ");
		String wirter = sc.nextLine();
		System.out.println("등록할 책의 isbn :");
		String isbn = sc.nextLine();
		System.out.println("등록할 책의 도서번호 : ");
		String bookNumber = sc.nextLine();
		
		Book book = new Book(isbn, bookNumber, title, wirter);
		
		//도서 번호 중복 체크
		if(bookList.contains(book)) {
			System.out.println("이미 등록된 도서번호입니다. 확인해주세요");
		}
		
		bookList.add(book);
		
		
		
		
		
	}

	private void checkOut() {
		//대출 가능한 도서들을 조회
		//Stream<Book> stream = bookList.stream();
		bookList
				.stream()
				.filter(b->!b.isLoan())//대출 가능한 도서만 추출
				.forEach(b->{//추출한 도서를 출력(forEach)
			System.out.println("===========");
			System.out.println(b);
			System.out.println("===========");
		});
		
		/*
		  for(Book tmp : bookList) {
		 
			if(!tmp.isLoan()) {
				System.out.println("===========");
				System.out.println(tmp);
				System.out.println("===========");
			}
		}*/
		
		
		//도서 번호를 입력
		sc.nextLine();//이전에 입력한 엔터 처리
		System.out.println("대출할 책 번호를 입력하시오");
		String num = sc.nextLine();
		
		//대출을 신청
		//도서 번호가 올바른지 확인
		//번호가 맞는 도서가 이쓴닞 확인
		//도서가 없으면 올바르지 않음
		//도서가 있으면 대출중인지 확인
		boolean possible
			= bookList
				.stream()
				.filter(b->!b.isLoan()&&b.getBookNumber().equals(num))
				.count() > 0;
		
		//올바르지 않으면(없는 도서번호이거나, 대출중인 도서인 경우)
		//대출할 수 없다고 출력
		if(!possible) {
			System.out.println("대출할수 없습니다");
			return;
		}
		
		//올바르면 대출을 진행
		//도서 대출 객체를 생성. 도서, 대출일, 대출기간 필요
		int index = bookList.indexOf(new Book(null, num, null, null));
		Date loanDate = new Date();
		LoanBrowsing lb
		= new LoanBrowsing(bookList.get(index), loanDate, 14);
		//대출열람 리스트에 추가
		loanList.add(lb);
		bookList.get(index).loanBook();//도서에 대출했다고 수정
		//대출일을 출력
		System.out.println("대출일 : " + lb.getLoanDateStr());
		//반납 예정일 출력
		System.out.println("반납일 : " + lb.getEstimatedDateStr());
		
		
	}

	private void returnBook() {
		//엔터처리
		sc.nextLine();
		//반납도서 번호를 입력
		System.out.println("도서 번호 : ");
		String num = sc.nextLine();
		//대출한 도서가 아니면 반납 X
		int index = bookList.indexOf(new Book(null, num, null, null));
		if(index == -1) {
			System.out.println("대출 도서가 아닙니다.");
			return;
			
		}
		//맞으면 반납
		//반납한 도서의 상태를 대출 가능으로 수정
		Book returnBook = bookList.get(index);
		returnBook.returnBook();
		
		//대출열람 리스트에서 대출한 도서에 반납일을 오늘 날짜로 수정
		//반납한 도서의 대출 열람을 찾아야 함
		int lbIndex = loanList.lastIndexOf(new LoanBrowsing(returnBook, null, 14));
		LoanBrowsing tmpLb = loanList.get(lbIndex);
		tmpLb.setReturnDate(new Date());
		System.out.println("대출일 : " + tmpLb.getLoanDateStr());
		System.out.println("반납일 : " + tmpLb.getReturnDateStr());
		
		
	}

	private void runMenu() {
		System.out.println("============");
		System.out.println("1. 도서 등록");
		System.out.println("2. 대출");
		System.out.println("3. 반납");
		System.out.println("4. 종료");
		
		
	}
	private void mainMenu(int user) {
		switch(user) {
		case 1:
			insertBook();
			break;
		case 2:
			checkOut();
			break;
		case 3:
			returnBook();
		case 4:
			System.out.println("종료");
			break;
			
			
	}
	}

	private void saveLoan(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					for(LoanBrowsing tmp : loanList) {
						oos.writeObject(tmp);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	private void loadLoan(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				while(true) {
					LoanBrowsing tmp = (LoanBrowsing)ois.readObject();
					loanList.add(tmp);
				}
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				//ObjectInputStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable 인터페이스를 구현하지 않으면 발생
				System.out.println("LoanBrowsing 클래스를 찾을수 없습니다.");
			} 
	}
	
	
	
	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				while(true) {
					Book tmp = (Book)ois.readObject();
					bookList.add(tmp);
				}
			} catch (FileNotFoundException e) {
				System.out.println("불러올 파일이 없습니다.");
			} catch (EOFException e) {
				System.out.println("불러오기 완료");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				//ObjectInputStream을 이용하여 객체단위로 읽어올 때 클래스가 Serializable 인터페이스를 구현하지 않으면 발생
				System.out.println("book 클래스를 찾을수 없습니다.");
			} 
	}
	

	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					for(Book tmp : bookList) {
						oos.writeObject(tmp);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
