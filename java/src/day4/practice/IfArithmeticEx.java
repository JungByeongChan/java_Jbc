package day4.practice;

import java.util.Scanner;

public class IfArithmeticEx {

	public static void main(String[] args) {
		// 산술 연산자와 두 정수를 입력받아 산술 연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요.
		// ex) input 2 nums and arithmatic operator : 1 + 2 [엔터]
		// 1 + 2 = 3
		// 1 ? 2 -> ? is nat operator!
		
		/*
		 산술연산자 : op 두 정수 : num1 num2
		 op가 +이면 num1 + num2를 출력하고
		 op가 -이면 num1 - num2를 출력하고
		 op가 *이면 num1 * num2를 출력하고
		 op가 /이면 num1 / num2를 출력하고
		 op가 %이면 num1 % num2를 출력하고
		 op가 산술연산자가 아니면 op is not arithmetic operator!를 출력
		 
		  
		 */

		char op;
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 nums and arithmatic operator(ex : 1 + 2) : ");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		char op1 = sc.next().charAt(0);
		
		if(op1 == '+') {
			String str1 = "" + num1 + op1 + num2 + "=" + (num1 + num2);
			
			System.out.println(str1);
		}

		else if(op1 == '-') {

			String str2 = "" + num1 + op1 + num2 + "=" + (num1 - num2);
			
			System.out.println(str2);
				
		}
		
		else if(op1 == '*') {
			String str3 = "" + num1 + op1 + num2 + "=" + ((double)num1 * num2);
			
			System.out.println(str3);
	
		}
		else if(op1 == '/') {
			String str4 = "" + num1 + op1 + num2 + "=" + (num1 / num2);
			
			System.out.println(str4);
	
		}
		else if(op1 == '%') {

			String str5 = "" + num1 + op1 + num2 + "=" + (num1 % num2);
			
			System.out.println(str5);
	
		}
		
		
		else{
			System.out.println("op is not arithmetic operator!");
		}
		
		
		/*
		if() {
			
		}else if(){
			
		}else if(){
			
		}else {
			System.out.println("Invalid input.");
		}
		*/
		
		
		
	}

}
