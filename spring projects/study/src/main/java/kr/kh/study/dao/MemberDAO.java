package kr.kh.study.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.vo.MemberVO;

public interface MemberDAO {

	int selectCountMember();

	MemberVO selectMember(@Param("me_id")String me_id);

	boolean insertMember(@Param("m")MemberVO member);

	MemberVO selectMemberLogin(@Param("me_id")String me_id, @Param("me_pw")String me_pw);

	boolean loginMember(@Param("me_id")MemberVO member);

}
