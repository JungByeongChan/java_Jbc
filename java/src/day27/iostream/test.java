package day27.iostream;

import java.util.Scanner;

public class test {
	public static void count() {
		
		do{
			Scanner sc = new Scanner(System.in);
			
			
			

			System.out.print("문자열을 입력하시오 : ");

			String str = sc.nextLine();
			
			
			if(str == "exit"){
				

			 break;
			 

			}
			 System.out.println(str + "잘못된입력");




			}while(true);


	
	

	}



}
