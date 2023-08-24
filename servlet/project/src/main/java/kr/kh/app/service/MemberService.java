package kr.kh.app.service;

import kr.kh.app.vo.MemberVo;

public interface MemberService {

	boolean signup(MemberVo member);

	boolean withdraw(MemberVo member);
	
}
