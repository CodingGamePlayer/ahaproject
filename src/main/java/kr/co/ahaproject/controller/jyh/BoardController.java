package kr.co.ahaproject.controller.jyh;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.BoardDTO;

public interface BoardController {
	
	/*
	 *  gboard:자유게시판
	 *  noticeboard:공지사항
	 *  qnaboard:qna
	 * */
	
	//전체조회
	String list(Model model);
	
	
	
	
	

}
