package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.pagenation.Criteria;
import kr.kh.spring.pagenation.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2);
		//���� �������� �´� �Խñ��� �����;���
		List<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("pm",pm);
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board,user)) {
			msg = new Message("/board/list", "�Խñ��� ����߽��ϴ�.");
		}else {
			msg = new Message("/board/insert","�Խñ� ��� ����");
		}
		System.out.println(board);
		model.addAttribute("msg",msg);
		return "message";
	}
	@GetMapping("/detail")
	public String detail(Model model,Integer bo_num, Criteria cri) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		model.addAttribute("board",board);
		model.addAttribute("cri",cri);
		return "/board/detail";
	}
}
