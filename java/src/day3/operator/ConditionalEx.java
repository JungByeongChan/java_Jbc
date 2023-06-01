package day3.operator;

public class ConditionalEx {

	public static void main(String[] args) {
		// 나이가 20살 이상이면 성인, 아니면 미성년자를 출력하는 코드를 작성하시오
		
		int age = 25;
		String str;
		
		str = age >= 20 ? "adult" : "minor";
		System.out.println(age + "years old is a " + str);
	}

}
