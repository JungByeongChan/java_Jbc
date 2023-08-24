package kr.kh.app.vo;

import lombok.Data;

@Data
public class BoardVo {
	
	private int bo_num;
	private String bo_title;
	private String bo_me_id;
	
	public BoardVo(String title, String id) {
		this.bo_title = title;
		this.bo_me_id = id;
	}

	public BoardVo(int bo_num, String title, String id) {
		this.bo_num = bo_num;
		this.bo_title = title;
		this.bo_me_id = id;
	}

}
