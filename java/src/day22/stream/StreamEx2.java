package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list =Arrays.asList(
				new Student(1,1,1,"Hong",100,90,80),
				new Student(1,1,2,"Ling",10,30,50),
				new Student(2,1,1,"Park",13,15,17),
				new Student(3,1,1,"Lee",100,69,70),
				new Student(3,3,2,"Kim",40,50,60));
				//국어 성적이 60점 이상인 학생들의 이름을 출력
		Stream<Student> stream = list.stream();
		stream.filter(s->s.getKor()>=60).map(s->s.getName()).forEach(name -> System.out.println(name));
		stream = list.stream();
		stream.filter(s->s.getKor()>=60).forEach(std -> System.out.println(std.getName()));
		//국어 성적 종합
		stream = list.stream();
		int sum = stream.mapToInt(std->std.getKor()).sum();
		System.out.println(sum);
		//국어 성적 평균stream = list.stream();
		stream = list.stream();
		double avg = stream.mapToInt(std->std.getKor()).average().getAsDouble();
		System.out.println(avg);
		
		//국어 성적의 종합
		stream = list.stream();
		sum = stream.map(std->std.getKor()).reduce(0,(a,b)->a+b);
		System.out.println(sum);

		
	}
	
}
@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	int kor, math, eng;
}