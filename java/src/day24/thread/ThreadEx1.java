package day24.thread;

public class ThreadEx1 {

	public static void main(String[] args) {
		ChildThread1 chTread = new ChildThread1();
		chTread.start();
		for(int i = 0;i<10;i++) {
			System.out.print("work1");
		}
		// 싱글스레드는 앞의 작업이 다 끝나야 뒤의 작업이 시작됨
		/*
		for(int i = 0; i<10; i++) {
			System.out.print("-");
		}
		*/
		
	}

}

class ChildThread1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			System.out.print("work2");
		}
	}
}