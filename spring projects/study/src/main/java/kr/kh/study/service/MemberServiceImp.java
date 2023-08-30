package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;


@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public int count() {
		return memberDao.selectCountMember();
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null 
		|| member.getMe_id() == null 
		|| member.getMe_pw() == null 
		|| member.getMe_email() == null) {
			return false;
		}
		//��ȿ���˻�
		if(!checkRegexMember(member)) {
			return false;
		}
		//���̵� �ߺ�üũ
		//���̵�� ȸ�������� ������
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) {
			return false;
		}
		//ȸ����������
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		return memberDao.insertMember(member);
	}

	private boolean checkRegexMember(MemberVO member) {
		// �ʿ��ϸ� ��ȿ�� �˻� ����
		return false;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null 
				|| member.getMe_id() == null 
				|| member.getMe_pw() == null 
				|| member.getMe_email() == null) {
					return null;
				}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user == null) {
			return null;
		}
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}
}
