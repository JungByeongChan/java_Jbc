package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {
		// 
		int num1,num2;
		char op;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input : num1,2 and operator");
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		
		try {
			switch(op) {
			case '+':
				System.out.println("" + num1 + op + num2 + "=" + (num1 + num2));
				break;
			case '-':
				System.out.println("" + num1 + op + num2 + "=" + (num1 - num2));
				break;
			case '*':
				System.out.println("" + num1 + op + num2 + "=" + (num1 * num2));
				break;
			case '/':
				System.out.println("" + num1 + op + num2 + "=" + ((double)num1 / num2));
				break;
			case '%':
				System.out.println("" + num1 + op + num2 + "=" + (num1 % num2));
				break;
				default:
					System.out.println("not operator!");
			}
		}catch(InputMismatchException e) {
			System.out.println("Wrong Input!");
		}catch(ArithmeticException e) {
			System.out.println("Not operatoration!");
		}
		catch(Exception e) {
			System.out.println("Exception");
		}
		test1();
		test2();
		
		
	}
	public static void test1() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!!!");
			return;
		}finally {
			System.out.println("Method1 Exit!");
		}
	}
	public static void test2() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!!!");
			return;
		}
		System.out.println("Method2 Exit!"); // return이 없으면 실행을하지않음
	}

}
