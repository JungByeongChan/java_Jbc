package day2.variable;

public class StringEx2 {

	public static void main(String[] args) {
		String str = "";
		char op = '+';
		int num1 = 1, num2 = 2;
		str = num1 + op + num2 + "=" + (num1+num2);
		//num1 + op가 먼저 계산이 되서 +에 해당하는 43과 1이 더해져서 44가 됨
		//44와 2가 더해져 46
		//46과 문자열 =이 더해져서 46=
		System.out.println(str);
		str = "" + num1 + op + num2 + "=" + (num1+num2);
		// 빈 문자열과 num1이 계산 되서 문자열 1
		// 문자열 1과 +가 더해져서 문자열 1+
		// 문자열 1+와 2가 더해져서 문자열 1+2
		System.out.println(str);

	}

}
