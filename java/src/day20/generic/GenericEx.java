package day20.generic;

import java.util.Scanner;

public class GenericEx {

	public static void main(String[] args) {
		// 
		Student<Integer> std = new Student<Integer>();
		std.kor = 10; //Integer라는 정수형 클래스로 선언했기 때문에 10.0하면 오류
		Student<Double> std2 = new Student<Double>();
		std2.kor = 10.0;
		/*
		Student<Scanner> std3 = new Student<>();
		std3.kor = 10;
		*/
		print(std2);
		GenericEx.<Double>print(std2);
		GenericEx.print(std2);//std2가 Double로 되어 있어서 print의 T를 Doutble이라 추정이 가능하기에 생략가능
		

	}
	
	//학생 정보를 출력하는 메서드
	public static <T extends Number> void print(Student<T> std) {
		System.out.println(std.greade);
		System.out.println(std.classNum);
		System.out.println(std.num);
		System.out.println(std.name);
		System.out.println(std.kor);
		
	}

}
