package kr.co.ahaproject.controller.mskim;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface CardController {
	
	// 카드 전체 리스트
	String card(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);
	
	// 카드 거래처별 리스트
	ModelAndView cardClient(ModelAndView mav, String cl_code);
	
	// 카드 정보 등록 폼 이동
	String card_form(Model model);
	
	// 카드 정보 수정 폼
	ModelAndView card_edit(ModelAndView mav, int card_id);
	

}
