package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import array.Array;

public class StreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> arrStream = Arrays.stream(arr);
		Stream<Integer> listStream = list.stream();
		
		//전체출력
		arrStream.forEach(num->System.out.println(num));
		listStream.forEach(num->System.out.println(num));
		System.out.println("===========");
		
		//3보다 큰 수를 출력
		arrStream = Arrays.stream(arr);//스트림은 한번 사용하면 끝이기 때문에 다싯 선언해야함
		arrStream.filter(num-> num>3).forEach(num->System.out.println(num));
		System.out.println("====");
		listStream = list.stream();
		listStream.filter(num ->num>3).forEach(num->System.out.println(num));
	}

}
