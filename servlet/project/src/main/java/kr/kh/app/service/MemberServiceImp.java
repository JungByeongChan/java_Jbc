package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.dao.MemberDAO;
import kr.kh.app.vo.MemberVo;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH = "kr/kh/app/config/mybatis-config.xml";
	
	
	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			//true의 역할 : 쿼리(insert,update,delete) 실행 후 자동 커밋되게 해줌 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean signup(MemberVo member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		// 아이디 중복 확인
		// 아이디가 일치하는 회원정보를 가져옴
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		System.out.println(dbMember);
		// 회원정보가 있으면 아이디가 중복이라는 의미
		if(dbMember != null) {
			return false;
		}
		memberDao.insertMember(member);
		return true;
	}
	
	public boolean withdraw(MemberVo member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return false;
		}
		//아이디가 일치하는 회원 정보를 가져옴
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		// 회원정보가 있으면 탈퇴 불가능
		if(dbMember == null) {
			return false;
		}
		//비번이 일치하지 않으면
		if(!dbMember.getMe_pw().equals(member.getMe_pw())) {
			return false;
		}
		
		memberDao.deleteMember(member.getMe_id());
		return true;
	}



	

}
