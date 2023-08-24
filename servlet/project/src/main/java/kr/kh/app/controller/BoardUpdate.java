package kr.kh.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;
import kr.kh.app.vo.BoardVo;

public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();

   
    public BoardUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bo_num = Integer.parseInt(request.getParameter("bo_num"));
		BoardVo board = boardService.getBoard(bo_num);
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bo_num = Integer.parseInt(request.getParameter("bo_num"));
		String title = request.getParameter("title");
		BoardVo board = new BoardVo(bo_num, title, null);
		String url = "/board/update?bo_num=" + bo_num;
		String msg ="게시글 수정 실패";
		try {
			if(boardService.updateBoard(board)){
				url = "/board/detail?bo_num=" + bo_num;
				msg = "게시글 수정 성공!";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);

	}

}
