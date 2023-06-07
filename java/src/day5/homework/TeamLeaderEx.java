package day5.homework;

import java.util.Scanner;

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
			
		
		switch(random % 3) {
			case 0 :
				System.out.println(random + " 번의 학생은 " + "Team leader" + " 이다");
			break;
			default :
				System.out.println(random + " 번의 학생은 " + "member" + " 이다");
		
		}
		
		
	
		System.out.println(random);
		
		String leader1 = random % 3 == 0 ? "Team ledaer" : "member";
		
		System.out.println(random + " 번의 학생은 " + leader1 + " 이다"); 
		
		// 이하의 코딩은 강사풀이
		int num;
		Scanner sc = new Scanner(System.in);
				
		//학생 번호를 입력
		System.out.println("input student number : ");
		num = sc.nextInt();
				
		
		//학생 번호가 팀장번호인지 아닌지를 판별
		//번호가 3 의 배수이면 팀장이라고 출려갛고 아니면 팀원이라고 출력
		//num을 3으로 나누었을 때 나머지가 0과 같다면 팀장, 아니면 팀원으로 출력
		//num % 3 == 0
		switch(num % 3) {
		case 0 :
			System.out.println("student number " + num + " is the team leader");
			break;
			default:
			System.out.println("student number " + num + " is a meber of the team.");
		}
		sc.close();
		
	}

}
