package day24.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InetAddress inetAdress = null;
		//이름이 localhost인 곳의 IP 주소 정보를 가져옴
		try {
			inetAdress = InetAddress.getByName("localhost");
			System.out.println(inetAdress);
			//네이버 사이트의 ip 주소 조회
			inetAdress = InetAddress.getByName("www.naver.com");
			System.out.println(inetAdress);
			inetAdress = inetAdress.getLocalHost();
			System.out.println(inetAdress);
			InetAddress [] address = inetAdress.getAllByName("www.naver.com");
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
