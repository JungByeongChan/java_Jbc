package day20.homework.vocabularynote.vo;

public class Word {
	//멤버 변수
	private String title;
	private String meaning[];
	private int meaningCount;
	//생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5];//기본 5개의 뜻을 저장할 수 있도록.
		this.meaning[0] = meaning;
		meaningCount++;
	}
	public Word(String title){
		this.title = title;
		this.meaning = new String[5];//기본 5개
	}
	
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];//기본 5개
		for(int i = 0 ; i < w.meaningCount; i++) {
			this.meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	//메서드
	/**
	 * 단어와 뜻을 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i < meaningCount ; i++) {
			System.out.println(i + 1 + " . " + meaning[i]);
			
		}
	}
	/**
	 * 뜻을 추가하는 메서드
	 * 매개변수 : 추가될 뜻 = > String meaning 
	 * 리턴타입 : void
	 * 메서드명 : addmeaning
	 */
	
	public void addMeaning(String meaning ) {
		if(meaningCount == this.meaning.length) {
			System.out.println("It's all filled. ");
			return;
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
		
		
	}
	/**
	 * 뜻을 제거하고 제거여부를 알려주는 메서드
	 * 매개변수 : 제거할 뜻의 번호 int num
	 * 리턴타입 : 제거여부 => boolean
	 * 메서드명 : removeMeaning
	 */
	public boolean removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			//System.out.println("I can't work.");
			return false;
		}
		//num-1번지부터 하나씩 당겨와서 덮어쓰기함
		for(int i = num-1 ; i < meaningCount - 1 ; i++) {
			meaning[i] = meaning[i+1];
		}
		//마지막에 쓸모없는 데이터를 지움
		meaning[meaningCount - 1] = null;
		//제거 됐으면 뜻 개수를 하나 줄임
		meaningCount--;
		
		return true;
	}
	//getter
	public String getTitle() {
		return title;
	}
	
	//setter
	public void setTitle(String title) {
		this.title = title;
	}
	/** 수정할 뜻의 번지와 수정할 뜻이 주어지면 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번호, 수정할 뜻 => int maeningNum, String meaning
	 * 리턴타입 : 수정여부 => boolean
	 * 메서드명 : updateMeaning
	 * @param maeningIndex
	 * @param meaning2
	 * @return
	 */
	public boolean updateMeaning(int meaningNum, String meaning) {
		// 수정할 뜻의 번지가 잘못된 경우
		if(meaningNum > meaningCount || meaningNum <= 0) {
			return false;
		}
		//meaningNum은 1부터이고 번지는 0부터이기 때문에 빼기 1을 한다.
		this.meaning[meaningNum - 1] = meaning;
		return false;
	}
	

}
