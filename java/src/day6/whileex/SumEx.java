package day6.whileex;

public class SumEx {

	public static void main(String[] args) {
		// 1부터 n까지 합을 구하는 코드를 작성하시오.(n은 10)
		/* 반복횟수 : i는 1부터 n까지 1씩 증가
		 * 규칙성 : sum += i
		 * 반복문 종료 후(경우에 따라서 없을 수도 잇음) :
		 * 			sum0 = 0
		 * i = 1	sum1 = sum0 + 1
		 * i = 2 	sum2 = sum1 + 2
		 * i = 3 	sum3 = sum2 + 3
		 * ...
		 * i = 10 	sum10 = sum9 + 10
		 * i = n 	sum = sum + i(n) => sum += i
		 *  */
		
		int n = 5, sum = 0;
		int i = 1;//i는 1부터
		while(i <= n ) {//i는 n까지
			sum += i;
			i++;//1씩 증가
		}
		System.out.println("1~ " + n + " sum :" + sum);

	}

}
