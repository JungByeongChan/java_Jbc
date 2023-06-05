package day5.homework;

public class TeamLeaderEx {

	public static void main(String[] args) {
		// 30명의 학생이 있는 반에서 1번부터 연속된 번호를 가진 3명의 학생이 1조가 되도록 나누었다
		// 이 때 가장 큰 번호인 학생이 조장이된다
		// 학생 번호가 주어졌을 때 조장인지 조원인지 판별하는 코드를 작성하세요.
		/*
		(switch문으로)
		input student number :
		1
		student number 1 is a member of the team.
		input student number :
		6
		student number 6 is the team leader.
		*/
		
		int min = 1, max = 30;
		int random = (int)(Math.random() * (max - min + 1) + min);
		
		System.out.println(random);
		
		String leader = random % 3 == 0 ? "Team ledaer" : "member";
		
		System.out.println(random + " 번의 학생은 " + leader + " 이다"); 
		
			

	}

}
