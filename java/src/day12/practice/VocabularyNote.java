package day12.practice;
/*
 * 단어장 클래스
 * - 단어들의 모임
 * - Word들의 모임
 */

public class VocabularyNote {
	//멤버 변수
	//단어들
	private Word2 wordList[];//단어들
	private int wordCount;//저장된 단어의 개수
	
	//생성자
	public VocabularyNote() {
		wordList = new Word2[10];
	}
	
	public VocabularyNote(Word2 wordList[]) {
		// 기존 단어장의 크기와 10을 비교해서 큰수로 단어장 크기를 선택
		int size = wordList.length > 10 ? wordList.length : 10;
		this.wordList = new Word2[10];
		for(int i = 0 ; i < wordList.length ; i++) {
			this.wordList[i] = new Word2(wordList[i]);
		}
		wordCount = wordList.length;
	}
	
	
	
	//메서드
	/**
	 * 단어들을 출력하는 메서드
	 * 매개변수 : 없음 
	 * 리턴타입 : 없음
	 * 메서드명 : print
	 */
	
	public void print() {
		System.out.println("==============");
		for(int i = 0 ; i < wordCount ; i++) {
			wordList[i].print();
			System.out.println("============");
		}
	}
	/**
	 * 단어가 주어지면 단어장에 추가하는 메서드(단어 객체를 넘겨주는 경우)
	 * 매개변수 :	단어(단어 객체) => Word word
	 * 리턴타입 : 없음 => void
	 * 메서드명 : insert
	 */
	public void insert(Word2 word) {
		//단어장(배열)에 단어가 다 찼으면 추가를 하지 못함.
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary note is full");
			return;
		}
		//깊은 복사를 위해 Word의 복사 생성자를 이용하여 새 단어를 생성한 후 추가(원본을 남기기 위함)
		wordList[wordCount++] = new Word2(word);
	}
	
	/**
	 * 단어와 뜻이 주어지면 없는 단어이면 새로 단어를 추가하고,
	 * 있는 단어이면 뜻만 새로 추가하는 메서드
	 * 매개변수 : 단어와 뜻 => String title, String meaning 
	 * 리턴타입 : 없음 => void
	 * 메서드명 : insert
	  */
	
	//(단어와 뜻을 넘겨주는 경우)
	public void insert(String title, String meaning) {
		//단어장(배열)에 단어가 다 찼으면 추가를 하지 못함.
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary note is full");
			return;
		}
		int index = indexOf(title);
		//없는 단어이면 새 단어로 추가
		if(index == -1) {
			//단어의 뜻을 이용해 단어 객체를 생성한 후 단어장에 추가
			wordList[wordCount++] = new Word2(title, meaning);
			return;
		}
		//있는 단어이면 뜻을 추가
		wordList[index].addMeaning(meaning);
		
	}
	
	/**
	 * 단어와주어지면 단어장에서 삭제하는 메서드
	 * 매개변수 : 삭제할 단어 => String title
	 * 리턴타입 : 없음 => void
	 * 메서드명 : delete
	  */
	
	public void delete(String title) {
		// 우선적으로 삭제할 단어가 어디있는지 찾아야함
		int index = indexOf(title);
		// 단어가 단어장에 없으면 알림 메세지 출력 후 종료
		if(index == -1){
			System.out.println("no words found");
			return ;
		}
		// 찾은 위치부터 한칸씩 밀어줌 // wordCount-1로 한 이유는 두개씩 작업해야하기때문
		for(int i = index; i < wordCount -1; i++) {
			wordList[i] = wordList[i+1];
		}
		
		//단어의 개수를 하나 줄여줌
		wordCount--;
		// 마지막 단어를 비워줌(null)
		wordList[wordCount] = null;
		
	}
	
	/**
	 * 단어가 주어지면 단어를 있는 위치를 알려주는 메서드
	 * 단어가 없으면 -1을리턴(배열의주소는 0번지부터 시작하기 때문에 음수가 번지로 나올수가 없음//음수이기만하면 됨)
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 위치 => 번지 => 정수 => int
	 * 메서드명 : indexOf
	 * */
	public int indexOf(String title) {
		//단어장에 등록된 단어들을 조회
		for(int i = 0 ; i < wordCount ; i++) {
			//단어가 같으면 i번지를 리턴
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		//여기까지 왔다는 뜻은 일치하는 단어가 없다는 이야기이기 때문에 -1을 리턴
		return -1;
	}
	
	/**
	 * 단어가 주어지면 단어장에 해당 단어를 출력하는 메서드
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 없음 = > void
	 * 메서드명 : search
	 */
	public void search(String title) {
		int index = indexOf(title);
		
		if(index == -1) {
			System.out.println("No words found");
			return ;
			
		}
		wordList[index].print();
	}
	
	/**
	 * 단어와 수정할 뜻의 번호와 수정할 뜻의 의미가 단어의 뜻을 수정하는 메서드
	 * 매개변수 : 단어, 수정할 뜻 번호, 수정할 뜻
	 * 			=> String title, int maeningIndex, String meaning
	 * 리턴타입 : 없음 => void
	 * 메서드명 : updateMeaning
	 */
	public void updateMeaning(String title, int meaningIndex, String meaning) {
		
		int index = indexOf(title);
		if(index == -1) {
			System.out.println("No words found");
			return;
		}
		if(!wordList[index].updateMeaning(meaningIndex, meaning));{
			System.out.println("Wrong number");
		}
	}
	
	/**
	 * 단어와 수정할 단어가 단어가 주어지면 단어를 수정하는 메서드
	 * 매개변수 : 단어와 수정할 단어 => String title, String updateTitle
	 * 리턴타입 : 없음 => void
	 * 메서드명 : updateTitle
	 *  */
	public void updateTitle(String title, String updateTitle) {
		int index = indexOf(title);
		if(index == -1) {
			System.out.println("No words found");
			return;
		} 
		wordList[index].setTitle(updateTitle);
	}
	
}

	

