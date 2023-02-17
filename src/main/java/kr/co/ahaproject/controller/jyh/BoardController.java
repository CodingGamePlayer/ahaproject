package kr.co.ahaproject.controller.jyh;


import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Account;
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
	String listQnA(PageRequestDTO pageRequestDTO, Model model);

	//작성
	String create(Model model,BoardDTO dto);
	String createQnA(Model model,BoardDTO dto);

	//수정
	String detail(int id, Model model, Account account);
	String detailQnA(int id, Model model, Account account);


		
	
	

	


	
	
	

	
	
	
	
	
	
	

}
