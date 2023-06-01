package day3.homework;

import java.util.*;

public class Ex6 {

	public static void main(String[] args) {
		/*성별(M:남성,W:여성)를 입력받아 M이면 남성을, W이면 여성을 출력하는 코드를 작성하세요. if문 이용
		(package : day3.homework, file : Ex2_if) 
		input gender : 
		M
		Are you a women? man

		input gender : 
		W
		Are you a women? woman
		*/
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("성별을 입력하시오");
		
		int sr = sc.nextInt();
		char ch1 = 'm';
		char ch2 = 'w';
		if(sr == ch1) {
			System.out.println("남자입니다");
		}
		if(sr == ch2) {
			System.out.println("여성입니다");
		}
		sc.close();

	}

}
