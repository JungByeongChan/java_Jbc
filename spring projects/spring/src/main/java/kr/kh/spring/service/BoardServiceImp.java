package kr.kh.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.pagenation.Criteria;
import kr.kh.spring.util.UploadFileUtils;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.MemberVO;



@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "D:\\uploadfiles";
	// ���� ������ ������ ������ �� ���üũ�Ұ�(������ ��������)

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] fileList) {
		if(user == null || user.getMe_id()==null) {
			return false;
		}
		if(board == null||board.getBo_title()==null||board.getBo_title().length() == 0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		if(!boardDao.insertBoard(board)) {
			return false;
		}
		//÷�������� ���ε�
		if(fileList == null || fileList.length == 0) {
			return true;
		}
		for(MultipartFile file : fileList) {
			//uploadFileAndInsert(file);
			if(file != null) {
				//÷�������� ������ ���ε� �ϰ�, DB�� ����
				uploadFileAndInsert(file,board.getBo_num());
			}
			
		}
		
		return true;
	}

	private void uploadFileAndInsert(MultipartFile file, int bo_num) {
		if(file == null || file.getOriginalFilename().length() == 0) {
			//������ �̸��� ���ų� 0�̸� ���������ʴ´ٴ� �ǹ�
			return;
			
		}
		
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
			FileVO fileVo = new FileVO(bo_num, fi_name, file.getOriginalFilename());
			boardDao.insertFile(fileVo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardCount(cri);
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
	}
	
	@Override
	public void updateViews(Integer bo_num) {
		if(bo_num == null) {
			return;
		}
		boardDao.updateBoardViews(bo_num);
	}
}
