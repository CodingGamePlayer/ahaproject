package kr.co.ahaproject.controller.mskim;

import org.springframework.web.servlet.ModelAndView;

public interface ConstructionController {

	// 공사 전체 리스트
	ModelAndView construction(ModelAndView mav);
	
	// 공사 등록 폼 이동
	String construction_form();
	
	// 공사 정보 수정
	ModelAndView construction_edit(ModelAndView mav, int cst_id);
	
}
