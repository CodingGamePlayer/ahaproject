package kr.co.ahaproject.controller.jyh;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.CategoryDTO;



public interface CategoryboardController {

	
		//전체조회
		String list(Model model);
		
		//작성
		String create();
		
		//상세조회
		String detail(int ct_id, Model model);
		
		//수정
		String update(Model model,CategoryDTO dto);
		
		//삭제
		String delete(int ct_id);
			
		
}
