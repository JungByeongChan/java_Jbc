package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
		// 로또 프로그램을 Set을 이용하여 구현하시오.
		int min = 1, max = 10;
		int bonus;
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> user1 = new HashSet<>();
		
		while(set.size()<6) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
		}
		System.out.println(set);
		//보너스생성
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min);
		}while(set.contains(bonus));
		//사용자 입력
		
		while(user1.size() < 6) {
			System.out.println("input number : ");
			int user = sc.nextInt();
			user1.add(user);
			
			
		}
		//일치하는 개수 확인
		int count = 0;
		for(Integer tmp : user1) {
			if(set.contains(tmp)) {
				count++;
			}
		}
		//개수를 확인하여 등수 체크
		switch(count) {
		case 6: System.out.println("rank 1"); break;
		case 5:
			if(user1.contains(bonus)) {
				System.out.println("rank 2");
			}else {
				System.out.println("rank 3");
			}
			break;
		case 4:
			System.out.println("rank 4");break;
		case 3:
			System.out.println("rank 5");break;
			default:
				System.out.println("fall");break;
		}
		
		
		
	}

}
