package kr.co.ahaproject.controller.mskim;

import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;

public interface ConReplyController {
	
	ModelAndView selectAll(PageRequestDTO pageRequestDTO, ModelAndView mav);
	
	ModelAndView registForm(ModelAndView mav);
	
	ModelAndView editForm(ModelAndView mav, ConReplyDTO conReplyDTO);

}
