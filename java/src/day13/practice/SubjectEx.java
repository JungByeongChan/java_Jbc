package day13.practice;

public class SubjectEx {

	public static void main(String[] args) {
		// 성적을 관리하기 위한 Subject 클래스를 만드세요.
		
		Subject sub1 = new Subject("korean");
		sub1.print();
		Subject sub2 = new Subject("english", 1, 1);
		sub2.updateScore(30, 40, 10);
		sub2.print();
		
		
		
		
				

	}

}
