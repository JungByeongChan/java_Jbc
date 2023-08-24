package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.vo.BoardVo;

public interface BoardDAO {

	void insertBoard(@Param("board") BoardVo board);

	ArrayList<BoardVo> selectBoardList();

	BoardVo selectBoard(@Param("bo_num") int bo_num);

	int deleteBoard(@Param("bo_num")int bo_num);

	int updateBoard(@Param("board")BoardVo board);

}
