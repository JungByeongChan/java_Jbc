package day4.homework;

import java.util.*;

public class TriangleEx {

	public static void main(String[] args) {
		
		int max;
		/*
		세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		(package : day4.homework, file : TriangleEx)
		세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
		input 3 integer num : 
		1 2 3 
		Unable to create triangle.
		input 3 integer num : 
		2 2 3 
		Able to create triangle.
		*/
		
		Scanner sr = new Scanner(System.in);
		System.out.println("A변의 정수를 입력하세요.");
		
		int A = sr.nextInt();
		
		System.out.println("B변의 정수를 입력하세요.");
		int B = sr.nextInt();
		
		System.out.println("C변의 정수를 입력하세요.");
		int C = sr.nextInt();
		/*
		if((A + B) > C) {
			System.out.println(A + "+" + B + "=" + C + " 따라서" + " 삼각형이 만들어질 수 있습니다.");
		}else {
			System.out.println(A + "+" + B + "=" + C + " 따라서" + " 삼각형이 만들어질 수 없습니다.");
		}
		
		String str = (A + B) > C ? "가능합니다" : "불가능합니다" ;
		
		System.out.println(A + "+" + B + "=" + C + " 따라서" + str);
		
		*/
		/*
		if((A + B) > C) {
			System.out.println(A + "+" + B + "=" + C + " 따라서" + " 삼각형이 만들어질 수 있습니다.");			
		}else if((B + C) > A){
			System.out.println(B + "+" + C + "=" + A + " 따라서" + " 삼각형이 만들어질 수 있습니다.");
		}else if((A + C) > B) {
			System.out.println(A + "+" + C + "=" + B + " 따라서" + " 삼각형이 만들어질 수 있습니다.");
		}else {
			System.out.println("삼각형이 만들어 질 수 없습니다.");
		}
		
		int abc = A > B ? ( A > C ? A : C ) : (B > C ? B : C);
		// 위와 같은 방식을 이러한 식으로 전개할수도있음
		System.out.println(abc);
		*/
		
		
		 if((A + B) > C) {
			max = A;			
		}else if((B + C) > A){
			max = B;
		}else {
			max = C;
		}
		
		if(A + B + C - max > max){
			System.out.println("가능합니다.");
		 
		 }
		 else{
			 System.out.println("불가능합니다.");
		 
		 }
		 
		
		

	}

}
