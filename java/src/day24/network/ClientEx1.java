package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		
		int port = 5001;//서버 포트 번호
		Scanner sc = new Scanner(System.in);
		
		//1. 소켓 생성
		
		
		try(Socket socket = new Socket();) {
			//2. 연결 요청
			socket.connect(new InetSocketAddress(port));
			System.out.println("[Conect!]");
			//3. 작업
			//서버에 데이터 전송을 위해 OutputStream 생성
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine();//보내려는 데이터
			byte [] bytes = str.getBytes();//hi를 byte로 변환
			os.write(bytes);//write는 꽉차야만 송신이가능하기때문에
			os.flush();//flush로 꽉차게 만듬
			InputStream is = socket.getInputStream();
			bytes = new byte[1024];
			
			int readCount = is.read(bytes);
			str = new String(bytes);
			System.out.println("server : " + str);
			
			is.close();
			os.close();
		} catch (IOException e) {
			System.out.println("Connection refused!");
			//e.printStackTrace();
		}
		

	}

}
