package day2.variable;

public class ConstantEx {
	//public static final int MAX = 90;
	public static void main(String[] args) {
		final int Max_AGE;
		//MAX_AGE : 상수, 100 : 리터럴
		Max_AGE = 100;
		//Max_AGE = 101;//에러 발생. 1번 초기화 한 후 수정하려고 했기 때문에
		System.out.println(Max_AGE);

		
		//지역 변수는 자동으로 초기화가 안됨
		int totalCount;
		//totalCount 변수가 초기화 되어있지 않기 때문에 사용이 불가 ==> 에러 발생
		//System.out.println(totalCount);
	}

}
