package day20.collection;

import java.util.HashSet;

public class SetEx {

	public static void main(String[] args) {
		// 
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		System.out.println(set);//순서를 보장하지않음 때문에 indexof는 사용불가능(번지가안정해져있기때문)
		set.remove(10);
		System.out.println(set);
		System.out.println(set.contains(20));
		System.out.println(set.size());

	}

}
