package day19.exception;

public class ThrowsEx {

	public static void main(String[] args) {
		// 
		int num1 = 1, num2 = 0;
		int res;
		int arr[] = {1,3,5};
		//res = mod2(num1, num2);
		//res = mod1(num1, num2);

		try {

			arr = null;
			printArray(arr);
			
			res = mod2(num1, num2);// 모드1은 결과가 나오지만 모드2는 결과가 나오지않음
			System.out.println(res);
		} catch (Exception e) {
			
			//System.out.println("Exception : / by zero");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Exit");
		
		

	}
	//try-catch를 이용하여 예외를 직접 처리
	public static int mod1(int num1, int num2) {
		try {
			int res = num1 % num2;
			return res;
		}catch(Exception e) {
			System.out.println("Exception : / by zero");
			return 0;
		}
		
	}
	//throws를 이용하여 예외처리를 미룸
	public static int mod2(int num1, int num2) throws RuntimeException{
		return num1 % num2;
	}
	
	
	public static void printArray(int arr[]) throws Exception {
		if(arr == null) {
			throw new Exception("Array is null");
		}
		
		
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
}
