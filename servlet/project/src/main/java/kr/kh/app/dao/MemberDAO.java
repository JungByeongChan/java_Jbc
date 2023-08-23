package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);
	
	
	
	void insertMember(@Param("member")MemberVo member);



	void deleteMember(@Param("me_id")String me_id);
	
}
