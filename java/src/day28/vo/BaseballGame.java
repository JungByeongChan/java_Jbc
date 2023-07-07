package day28.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseballGame {
	
	private List<Integer> com;
	private List<Integer> user;
	
	public BaseballGame() {
		com = new ArrayList<>();
		user = new ArrayList<>();
		generate(3, 1, 9);
	}
	
	//컴퓨터가 중복되지 않는 1~9사이의 랜덤한 값 3개를 생성하는 메서드
	public boolean generate(int size, int min, int max) {
		//만들어진 개수(배열의 숫자)가 0이하라면
		if(size <= 0) {
			return false;
		}// max가 min 보다 작으면
		if(max < min) {
			return false;
		}//생성되는 랜덤한 숫자의 개수가 만들어야 하는 숫자의 개수보다 작으면(무한루프)
		if(max - min +1 < size) {
			return false;
		}
		
		Random random = new Random();
		Set<Integer> set = new HashSet<>();
		
		//랜덤한 수를 size의 수 만큼 set에 추가
		while(set.size() < 3) {
			set.add(random.nextInt((max-min+1) + min));
		}
		//중복되지 않게 처리된 set을 List에 저장
		com.clear();
		com.addAll(set);
		//리스트를 섞어줌
		Collections.shuffle(com);
		return true;
	}
	
	//스트라이크 개수
	public int getStrike() {
		//
		int count = 0;
		for(int i=0;i<com.size();i++) {
			if(com.get(i) == user.get(i)) {
				count++;
			}
		}
		return count;
	}
	//볼 개수
	public int getBall() {
		int count = 0;
		//중복된 숫자가 몇개 있는지 확인(볼+스트라이크)
		for(Integer tmp : user) {
			if(com.contains(tmp)) {
				count++;
			}
		}
		return count - getStrike();
	}
	//user에 중복된 값과 범위를 넘어가는 값이 있는지 없는지 확인하는 메서드

	public boolean setUser(List<Integer> user2) {
		//user를 this.user에 복사한 후 같은것이 몇개씩 있는지 확인
		//증복되지 않았으면 1개씩 나올것이고, 중복된 값이 있으면 1보다 큼
		this.user.clear();
		this.user.addAll(user);
		for(Integer tmp1 : this.user) {
			if(tmp1 < 1 || tmp1 > 9) {
				return false;
			}
			int count = 0;
			for(Integer tmp2 : user) {
				if(tmp1 == tmp2) {
					count++;
				}
			}
			//중복된 값이 2개이면
			if(count > 1) {
				return false;
			}
			
		}
		return false;
	}

	public void printResult() {
		int strike = getStrike();
		int ball = getBall();
		if(strike > 0) {
			System.out.println(strike + "S");
		}
		if(ball>0) {
			System.out.println(ball + "B");
			
		}
		
		if(strike == 0 && ball == 0) {
			System.out.println("Out");
		}
		System.out.println();
		System.out.println(com);
		
	}

}
