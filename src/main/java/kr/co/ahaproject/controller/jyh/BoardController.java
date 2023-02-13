package kr.co.ahaproject.controller.jyh;


import org.springframework.ui.Model;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.BoardDTO;

public interface BoardController {
	
	/*
	 *  gboard:공지사항
	 *  noticeboard:자유게시판
	 *  qnaboard:qna
	 * */
	//공지사항
	
	//전체조회
	String list(Model model);
	
	//작성
	String create();
	
	//상세조회
	String detail(int b_id, Model model);
	
	//수정
	String update(Model model,BoardDTO dto);
	
	
	//자유게시판
	
	//전체조회
	String listAll(Model model);
	
	//작성
	String register();
		
	//상세조회
	String selectone(int b_id, Model model, BoardDTO dto);
		
	//수정
	String freeupdate(Model model,BoardDTO dto);
		
	
	
	

	


	
	
	

	
	
	
	
	
	
	

}
