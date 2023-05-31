package day2.variable;

public class OverFlowEx {

	public static void main(String[] args) {
		byte num = 127;
		++num;//num에 1을 증가
		System.out.println(num);//오버플로우가 발생해서 -128
		
		num = -128;
		--num;//num에 1을 감소
		System.out.println(num);//언더 플로우가 발생

	}

}
