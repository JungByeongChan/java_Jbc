package day11.practice;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		// 1~9 사이의 랜덤한 수를 중복되지 않게 3개 만들어서 배열에 저장한 후 출력하는 코드를 작성하시오.
		
		
		int min = 1; int max = 9;
		int []list = new int[3];
		
		//방법1 : 9번지까지 있는 배열을 이용
		//장점으로는 작업이 단순하지만, 단점으로는 저장 공간이 필요하다는 단점이있다.
		boolean cheaklist[] = new boolean[10];
		for(int i = 0 ; i < 3 ;) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			//cheaklist 배열에 랜덤번지에 있는 값이 false이면
			if(!cheaklist[random]){
				//random을 배열에 저장.
				list[i] = random;
				//i를 증가. 
				i++;
				//cheaklist배열에 random번지에 있는 값을 true로 변경
				cheaklist[random] = true;
			}
				
		}
		for(int i = 0; i < 3 ; i ++) {
			System.out.println(list[i]);
		}
		
		//방법2 : 저장된 값들을 비교
		int count = 0;	//현재 저장된 랜덤의 개수
		int i = 0;		// 반복문에서 사용할 변수
		
		while(count < 3) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			//이미 저장된 랜덤수들과 하나하나 비교해서 같은게 있는지 확인하여
			//있으면 반복문 종료
			for(i = 0; i < count ; i++) {
				if(random == list[i]) {
					break;
				}
			}
			//위 반복문에서 break를 만나지 않으면 i는 count일 때 종료하기 때문에
			//반복문 종료 후 i는 count와 같다.
			//하지만 break를 만나서 중간에 빠져 나오면 i는 count보다 작다.
			if(i == count) {
				list[count] = random;
				count++;
			}
		}
		
		
		
		System.out.println("==============");
		printArray(list);
		
		System.out.println("==============");
	//방법3 : 방법2를 메서드로 변형
	
	count = 0;
	while(count < 3) {
		int random = (int)(Math.random() * (max - min + 1) + min);
		
		//중복되지 않으면 배열에 저장 후 카운터 증가
		if(!contains(list, random, count)) {
			list[count] = random;
			count++;
			System.out.println(random);
		}
		
		
		
	}
	
	createRandomArray(min, max, list);
	System.out.println("=========");
	printArray(list);
	
	
	}
		
		

	
	/**
	 *  정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 *  매개변수 : 배열, 배열의 개수 => int list[], int size
	 *  리턴타입 : 없음 => void
	 *  메서드명 : printArray
	 */
	public static void printArray(int list[]) {
		int i;
		for(i = 0; i < list.length ; i++) {
			System.out.println(list[i]);
		}
	}
	/**
	 * 정수 num가 배열의 0번지부터 count 개만큼 확인했을 때,
	 * 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : list[], count, num // 중복을 확인할 배열 , 비교할 정수, 비교할 개수
	 * 리턴타입 : boolean
	 * 메서드명 : contains
	 */
	
	public static boolean contains(int list[], int num, int count) {
		
		for(int i = 0; i < count ; i++) {
			//중복 되면 중복된다고 알려줌
			if(num == list[i]) {
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
	public static void createRandomArray(int min, int max, int arr[]) {
		
		//배열이 생성되어 있지 않으면(배열이 null이면) 메서드 종료
		if(arr == null) {
			return;
		}
		//랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드를 종료
				//1~3 : 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음(무한루프에 빠지기 때문)
		if(max - min + 1 < arr.length) {
			return;
		}
		
		int count = 0;
		while(count < 3) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
	}
}
