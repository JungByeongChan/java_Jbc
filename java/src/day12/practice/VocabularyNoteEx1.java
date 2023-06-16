package day12.practice;

public class VocabularyNoteEx1 {
	public static void main(String[] args) {
		
		Word2 wordList[] = {
				new Word2("abc"),
				new Word2("def", "def is define")
		};
		VocabularyNote note = new VocabularyNote(wordList);
		//note.print();
		
		Word2 word = new Word2("a", "a");
		note.insert(word);
		//note.print();
		note.insert("b","b is b");
		//note.print();
		
		
		//note.delete("c");
		note.delete("a");
		//note.print();
		
		//note.search("a");
		//note.search("b");
		
		note.insert("b", "b");
		//note.print();
		
		note.updateMeaning("b", 2, "B");
		note.updateMeaning("b", 3, "B");//Wrong number
		//note.print();
		
		note.updateTitle("b", "B");
		//No words found 출력, 이미 앞에서 수정해서 b가 없음
		note.updateTitle("b", "B");
		note.print();
	}
}
