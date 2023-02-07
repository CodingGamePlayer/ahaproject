package kr.co.ahaproject.controller.mskim;

import org.springframework.web.servlet.ModelAndView;

public interface CardController {
	
	// 카드 전체 리스트
	ModelAndView card(ModelAndView mav);
	
	// 카드 거래처별 리스트
	ModelAndView card(ModelAndView mav, String cl_code);
	

}
