package day11.array;

public class ForEx1 {

	public static void main(String[] args) {
		// 향상된 for문은 조회할때만 사용, 수정할때는 X
		int arr[] = new int[]{4,5,2,1,9};
		
		for(int i = 0 ; i <arr.length; i++) {
			int tmp = arr[i];
			System.out.println(tmp);
		}
		System.out.println("==========");
		for(int tmp : arr) {
			System.out.println(tmp);
		}

	}

}
