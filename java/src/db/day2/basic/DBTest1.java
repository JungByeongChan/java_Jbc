package db.day2.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBTest1 {

	public static void main(String[] args) {
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.println("ID :");
		String dbID = sc.next();
		System.out.println("pw : ");
		String dbPw = sc.next();
		
//		con = DriverManager.getConnection("url - DBMS종류, 주소, DB명", "계정", "비번");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("success");
		
		
		/*
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//회원가입할 아이디와 비번을 입력
			System.out.println("ID : ");
			String id = sc.next();
			System.out.println("pw : ");
			String pw = sc.next();
			//쿼리에 있는 ? 대신 입력한 아이디와 비번을 넣어줌
			//setXXX(index, value): index는 ?의 위치로 1부터시작, value는 ?대신 들어갈 값
			ps.setString(1, id);
			ps.setString(2, pw);
			
			//쿼리를 실행
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		String sql ="update member set me_board_count = ? where me_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//? 에 들어갈 값을 설정
			System.out.print("ID :");
			String id = sc.next();
			ps.setString(2, id);
			
			System.out.print("정수 :");
			int count = sc.nextInt();
			ps.setInt(1, count);
			//쿼리를 실행
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/
		
		String sql = "select me_id, me_pw, me_board_count from member";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ?설정 => ?가 없어서 생략
			
			//쿼리를 실행
			
			ResultSet resultSet = ps.executeQuery();
			// select문은 반복문을 통해서 값을 읽어옴
			while(resultSet.next()) {
				String id = resultSet.getString(1);
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3);
				System.out.println(id + " : " + pw + " : " + boardCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//연결한 Connection을 닫아줌
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
