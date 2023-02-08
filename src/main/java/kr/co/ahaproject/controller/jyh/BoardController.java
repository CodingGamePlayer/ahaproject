package kr.co.ahaproject.controller.jyh;

import java.util.List;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.BoardDTO;

public interface BoardController {
	
	/*
	 *  gboard:공지사항
	 *  noticeboard:자유게시판
	 *  qnaboard:qna
	 * */
	
	//전체조회
	String list(Model model);
	
	//작성
	String create(Model model);
	
	
	
	
	

}
