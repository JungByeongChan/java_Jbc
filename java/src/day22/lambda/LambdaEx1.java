package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		// 
		interfaceA a = new interfaceA() {
			
			@Override
			public int getMax(int num1, int num2) {
				// TODO Auto-generated method stub
				return num1 >= num2 ? num1 : num2; 
			}
		};
		System.out.println(a.getMax(10, 20));
		interfaceA b = (num1, num2) ->{
			return num1 >= num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20));
		
		interfaceA c = (num1, num2)-> num1 >= num2 ? num1 : num2;
		System.out.println(c.getMax(10, 20));

	}

}

interface interfaceA{
	int getMax(int num1, int num2);
}