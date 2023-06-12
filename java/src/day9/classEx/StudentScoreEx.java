package day9.classEx;

public class StudentScoreEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// korscore를 인스턴스(영문),객체(한글번역)으로 표기함
		// Score1 korScore = new Score1(1,2, "Korean Language");
		
		Score1 korScore = new Score1();
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		
		
		
		Score1 mathScore = new Score1(1,2,"Math");
		System.out.println(mathScore.title);
		
		
		Score1 engScore = new Score1(1, 2, "englsh");//생성된 객체의 멤버들을 초기화 해주는 것
		System.out.println(engScore.title);

	}
	
	

}

//성적 클래스
class Score1{
	String title;//과목명
	int grade; //학년
	int semester;//학기
	double total;//총점수
	double midExam;//중간고사
	double finalExam;//기말고사
	double performance;//수행평가
	//Score1의 클래스의 기본 생성자
	public Score1() {
		/*
		 * title의 기본값은?
		 * grade의 기본값은?
		 * total의 기본값은?
		*/
		title = " ";
		grade = 1;
		semester = 1;
		
		
		
		 
		 
		
	}
	public Score1(int i, int j, String string) {
		// 
		title = string;
		grade = i;
		semester = j;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getMidExam() {
		return midExam;
	}
	public void setMidExam(double midExam) {
		this.midExam = midExam;
	}
	public double getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	public double getPerformance() {
		return performance;
	}
	public void setPerformance(double performance) {
		this.performance = performance;
	}
	
	public Score1(String title, int grade, int semester, double total, double midExam, double finalExam,
			double performance) {
		this.title = title;
		this.grade = grade;
		this.semester = semester;
		this.total = total;
		this.midExam = midExam;
		this.finalExam = finalExam;
		this.performance = performance;
	}
	
	
}
//학생 클래스
class student1{
	String name;//이름
	String residentNumber;//주민번호
	int  grade;//학년
	int classnum;//반
	int number;//번호
	int admissionYear;//입학년도
	Score1 korScore, engScore, mathScored;//국어 영어 수학 성적
}