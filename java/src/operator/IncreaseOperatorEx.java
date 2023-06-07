package operator;

public class IncreaseOperatorEx {

	public static void main(String[] args) {
		int A = 10, B = 10;
		System.out.println("작업 전 : " + A + "(전위형), " + B + "(후위형)");
		//전위형은 먼저 증가를 하고 동작을 하기 때문에 A을 증가 시킨 후 작업 중 문자열과 더한다.
		//후위형은 먼저 동작을 하고 증가를 하기 때문에 B를 앞의 문자열과 더한 후에 B를 증가한다.
		System.out.println("작업 중 : " + ++A + "(전위형), " + B++ + "(후위형)");
		System.out.println("작업 후 : " + A + "(전위형), " + B + "(후위형)");
		
		System.out.println("====================");
		
		A = B = 10;
		System.out.println("작업 전 : " + A + "(전위형), " + B + "(후위형)");
		++A;
		System.out.println("작업 중 : " + A + "(전위형), " + B + "(후위형)");
		++B;
		System.out.println("작업 후 : " + A + "(전위형), " + B + "(후위형)");
		
		

	}

}
