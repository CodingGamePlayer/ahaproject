package kr.co.ahaproject.controller.jyh;

import org.springframework.ui.Model;
import kr.co.ahaproject.dto.ReplyDTO;

public interface ReplyController {
	
	
	//전체조회
	String list(Model model,ReplyDTO dto);
		
	
		
	//상세조회
	String detail(Model model,ReplyDTO dto);
	//작성
	String create(Model model, ReplyDTO dto);
		
		

}
