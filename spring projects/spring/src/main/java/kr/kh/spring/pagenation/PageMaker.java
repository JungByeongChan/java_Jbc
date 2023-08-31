package kr.kh.spring.pagenation;

import lombok.Data;

@Data
public class PageMaker {
	private int startPage;//���� ���������̼ǿ��� ���� ������ ��ȣ
	private int endPage;//���� ���������̼ǿ��� ������ ������ ��ȣ
	private boolean prev;//���� ��ư Ȱ��ȭ ����
	private boolean next;//���� ��ư Ȱ��ȭ ����
	private int displayPageNum;//�� ���������̼ǿ��� �ִ� ������ ����
	private Criteria cri;//���� ���������̼ǿ��� ���� ������ ��ȣ
	private int totalCount;//���������������̼ǿ��� ������ ��������ȣ�� ���� ��ü ������ ����
	
	public void calculate() {
		
		endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		//������ ���������̼ǿ��� ������ ������ ��ȣ
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		//���� �������� ������ ���������̼��̸�
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		//ù��° ���������̼��̸� ���� ��ư ��Ȱ��ȭ
		prev = startPage == 1? false : true;
		
		//���������������̼��̸� ���� ��ư ��Ȱ��ȭ
		next = endPage == tmpEndPage ? false : true;
	}

	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
	
	
	
}
