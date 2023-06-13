package day10.practice;

public class RectEx {

	public static void main(String[] args) {
		// 그림판의 사각형을 그리기 위한 클래스를 생성하고 테스트하는 코드를 작성하시오.
		
		
		
		Rect r = new Rect(0,0,10,10);
		
		r.print();
		r.move(10, 10);
		r.print();
		r.resize(10, 10, 20, 20);
		r.print();
		r.resize(0, 0, 30, 30);
		r.print();
		
		System.out.println("R2 start!");
		
		Rect2 r2 = new Rect2(new Point(0,0), new Point(10,10));
		r2.print();
		r2.move(10, 10);
		r2.print();
		r2.resize(10, 10, 20, 20);
		r2.print();
		r2.resize(0, 0, 30, 30);
		r2.print();

	}

}
class Rect{
	private int LeftUpX, LeftUpY;
	private int rightDownX, rightDownY;
	
	
	public Rect(int LeftUpX, int LeftUpY, int rightDownX, int rightDownY) {
		this.LeftUpX = LeftUpX;
		this.LeftUpY = LeftUpY;
		this.rightDownX = rightDownX;
		this.rightDownY = rightDownY;
		
	}
	// 좌표를 입력할 필요가 없기 때문에 get,set이 필요가없음
	//메서드
	/**
	 * 사각형 정보를 출력하는 메서도
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print 
	 */
	public void print() {
		System.out.println("==========");
		System.out.println("LU point : " + LeftUpX + ", " + LeftUpY);
		System.out.println("Rd point : " + rightDownX + ", " + rightDownY);
	}
	/**
	 * 사각형을 움직이는 메서드
	 * 매개변수 : 이동시킬 왼쪽 위의 점 => int x, int y
	 * 리턴타입 :없음 => void
	 * 메서드명 : move
	 * 
	 */
	public void move(int x, int y) {
		int dx = LeftUpX - x;//이동한 x 좌표 거리
		int dy = LeftUpY - y;//이동한 y 좌표 거리
		LeftUpX = x;
		LeftUpY = y;
		rightDownX = rightDownX - dx;
		rightDownY = rightDownY - dy;
	}
	/**
	 * 사각형의 크기를 변경하는 메서드
	 * 매개변수 : 	변경된 사각형의 왼쪽 위의 x,y 좌표와
	 * 			가로, 세로가 주어지면 사각형의 크기를 변경하는 메서드
	 * 			=> int x, int y, int w, int h
	 * 리턴타입 : 없음 => void
	 * 메서드명 : resize
	 */
	public void resize(int x, int y, int w, int h) {
		LeftUpX = x;
		LeftUpY = y;
		rightDownX = x + w;
		rightDownY = x + h;
		
		
	}
	

		
}
	
class Rect2{
	//멤버변수
	private Point leftUp, rightDown;
	
	//생성자
	public Rect2(Point leftUp, Point rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
	}
	public Rect2(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		leftUp = new Point(leftUpX, leftUpY);
		rightDown = new Point(rightDownX, rightDownY);
	}
	public void print() {
		System.out.println("==========");
		System.out.println("LU point : ");
		leftUp.print();
		System.out.println("Rd point : ");
		rightDown.print();
	}
	
	public void move(int x, int y) {
		int dx = leftUp.getX() - x;//이동한 x 좌표 거리
		int dy = leftUp.getY() - y;//이동한 y 좌표 거리
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx, rightDown.getY() - dy );
	}
	public void resize(int x, int y, int w, int h) {
		leftUp.move(x, y);
		rightDown.move(x+w, y+h);
	}
}

