package day26.practice.book.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7231710373739797341L;
	private String isbn, bookNumber;
	private String title;
	private String 	Writer;
	private boolean loan;//대출 여부
	
	
	public Book(String isbn, String bookNumber, String title, String writer) {
		
		this.isbn = isbn;
		this.bookNumber = bookNumber;
		this.title = title;
		this.Writer = writer;
	}
	@Override
	public String toString() {
		return 	"도서번호 : " + bookNumber + "\n" +
				"도서제목 : " + title + "\n" +
				"도서저자 : " + Writer + "\n" +
				"ISBN   : " + isbn;
	}
	
	public void loanBook() {
		this.loan = true;//setLoan(true); 같은 의미
	}
	public void returnBook() {
		this.loan = false;//setLoan(false); 같은 의미
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookNumber, other.bookNumber);
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookNumber);
	}
	
	
	
	
	

}
