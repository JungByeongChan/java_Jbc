package kr.kh.study.service;

import org.springframework.ui.Model;

import kr.kh.study.vo.MemberVO;

public interface MemberService {

	int count();

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

}
