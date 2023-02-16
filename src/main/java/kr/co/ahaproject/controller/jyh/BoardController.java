package kr.co.ahaproject.controller.jyh;


import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface BoardController {
	
	/*
	 *  gboard:공지사항
	 *  noticeboard:자유게시판
	 *  qnaboard:qna
	 * */
	//공지사항
	
	//전체조회
	String list(PageRequestDTO pageRequestDTO, Model model);
	
	//작성
	String create(Model model,BoardDTO dto);
	
	//상세조회
	String detail(int b_id, Model model);
	
	//수정
	String update(int id, Model model);
		
	
	

	


	
	
	

	
	
	
	
	
	
	

}
