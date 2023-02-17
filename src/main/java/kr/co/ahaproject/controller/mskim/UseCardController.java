package kr.co.ahaproject.controller.mskim;

import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.dto.UseCardDTO;

public interface UseCardController {
	
	String selectAll(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);
	
	ModelAndView selectOne(PageRequestDTO pageRequestDTO, ModelAndView mav, int card_id);
	
	ModelAndView use_card_form(ModelAndView mav);
	
	ModelAndView getFindUcId(ModelAndView mav, int uc_id);

}
