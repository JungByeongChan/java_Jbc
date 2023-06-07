package operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		int A = 1, B = 2;
		int sum = A + B;
		int sub = A - B;
		int mul = A * B;
		double div = (double)A / B;// 1/2의 결과가 0이기에, 1.0/2로 바꾸어 0.5가 나오게 해야한다.
		int mod = A % B;
		
	
		
		System.out.println("" + A + '+' + B + "=" + sum);
		System.out.println("" + A + '-' + B + "=" + sub);
		System.out.println("" + A + '*' + B + "=" + mul);
		System.out.println("" + A + '/' + B + "=" + div);
		System.out.println("" + A + '%' + B + "=" + mod);
		
		
		
		
		
		int res = 0;
		//1 + res = 2;//대입연산자 = 왼쪽에 식이 와서 에러가 발생
		res = 2 - 1;//대입연산자 = 오른쪽에 식이 와서 에러 없이 잘 실행
		//1 = res + 1;//대입연산자 = 왼쪽에는 리터럴이 올 수 없음
		
		
	}

}
