package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDao;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDao memberDao;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return memberDao.selectMember();
	}
	
}
