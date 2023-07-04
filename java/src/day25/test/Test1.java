package day25.test;

import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
	/*	ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(1,2));
		list.add(new Point(x,y));
		list.add((3,4));
		*/
		
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(1,2));
		//정수형 변수 x,y가 선언되지않음
		int x = 1, y = 2;
		list.add(new Point(x,y));
		list.add(new Point(3,4));//new가 빠졋음
		
	}

}
