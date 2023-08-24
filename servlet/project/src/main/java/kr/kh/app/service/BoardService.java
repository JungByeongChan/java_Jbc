package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.vo.BoardVo;

public interface BoardService {

	boolean insertBoard(BoardVo board);

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(int bo_num);

	boolean deleteBoard(int bo_num);

	boolean updateBoard(BoardVo board);

}
