package kr.co.ahaproject.controller.mskim;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.dto.ConstructionDTO;

public interface ConstructionController {

	// 공사 전체 리스트
	ModelAndView construction(PageRequestDTO pageRequestDTO, ModelAndView mav);
	
	// 공사 등록 폼 이동
	ModelAndView construction_form(ModelAndView mav);
	
	// 공사 정보 수정
	ModelAndView construction_edit(ModelAndView mav, ConstructionDTO cstDTO);
	
}
