package kr.co.ahaproject.controller.mskim;

import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.dto.UseCardDTO;

public interface UseCardController {
	
	ModelAndView selectAll(ModelAndView mav);
	
	ModelAndView selectOne(ModelAndView mav, int card_id);
	
	ModelAndView use_card_form(ModelAndView mav);

}
