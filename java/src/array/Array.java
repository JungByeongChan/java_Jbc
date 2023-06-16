package array;

public class Array {
	// 배열 전체 출력
	public static void printArray(int arr[]) {
		System.out.print("[");
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + (i == arr.length-1? "" : " , "));
		}
		System.out.println("]");
	}
	
	//배열을 start 번지부터 end-1번지까지 출력
	public static void printArray(int arr[], int start, int end) {
		System.out.print("[");
		for(int i = start; i < end ; i++) {
			if(i >= arr.length) {
				break;
			}
			System.out.print(arr[i] + (i == end - 1 ? "" : " , "));
		}
		System.out.println("]");
	}
	/**
	 * 정수 num가 배열의 0번지부터 count 개만큼 확인했을 때,
	 * 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : arr[], count, num // 중복을 확인할 배열 , 비교할 정수, 비교할 개수
	 * 리턴타입 : boolean
	 * 메서드명 : contains
	 */
	// num가 배열의 원소 중에서 0번지부터 count개 안에 있는지 확인하는 메서드
	public static boolean contains(int arr[], int num, int count) {
		
		for(int i = 0; i < count ; i++) {
			//중복 되면 중복된다고 알려줌
			if(num == arr[i]) {
				return true;
			}
			
		}
		//이 위치까지 왔다는 것은 return true를 못만났다는 뜻이고,
		// 중복되지 않았다는 의미이다.
		return false;
	}
	/**
	 * min에서 max사이의 랜덤한 수를 생성해서 배열에 저장하는 메서드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : 없음 =>
	 * 메서드명 : createRandomArray
	 */
	
	public static int [] createRandomArray(int min, int max, int arr[]) {
		//max가 더 커야하는데 min이 더 클경우 바꿔주는 메서드
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		//배열이 생성되어 있지 않으면(배열이 null이면) 메서드 종료
		if(arr == null) {
			arr = new int[max - min + 1];
		}
		
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
		//1~3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음(무한루프에 빠지기 때문)
		if(max - min + 1 < arr.length) {
			return null;
		}
		
		
		
		int count = 0;
		while(count < arr.length) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		return arr; // 배열이 null이어도 임의로 배열을 만들어서 주겠다는 의미
	}
	
	
	/** 주어진 배열에 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 배열 => int arr[]
	 * 리턴타입 : 중복여부 => boolean
	 * 메서드명 : arraycheck
	 * 	 */
	
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {
			return false;
		}
		//arr 배열의 다른 번지들끼리 비교해서 같은 값이 있는지 확인하는 반복문
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length ; j++) {
				// 같은 번지면 건너 뜀
				if(i == j ) {
					continue;
				}
				// 다른 번지이고 값이 같으면 중복됐다고 리턴
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		// 반복문이 끝날때까지 중복이 안되면 중복이 안됐다고 리턴
		return false;
	}
	
	/**
	 * 정수형 배열이 주어지면 오름차순으로 버블 정렬하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : sort
	 */
	public static void sort(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i = 0 ; i < arr.length-1 ; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {//앞의것과 비교하기때문에 i가아닌 j 그리고 j+1
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			
		}
	}
	
	
	
	

}
