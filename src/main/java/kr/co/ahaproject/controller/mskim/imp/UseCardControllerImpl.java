package kr.co.ahaproject.controller.mskim.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.UseCardController;
import kr.co.ahaproject.service.mskim.CardService;
import kr.co.ahaproject.service.mskim.UseCardService;
import kr.co.ahaproject.service.mskim.imp.CardServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/worksite/use-card")
public class UseCardControllerImpl implements UseCardController {
	
	@Autowired
	private UseCardService ucs;
	@Autowired
	private CardService cs;

	@Override
	@GetMapping("/uc-list")
	public ModelAndView selectAll(ModelAndView mav) {
		mav.addObject("ucjs", ucs.selectAll());
		mav.setViewName("user/use-card/use-card-list");
		return mav;
	}

	@Override
	@GetMapping("/c-list")
	public ModelAndView selectOne(ModelAndView mav, @RequestParam("card_id") int card_id) {
		
		mav.addObject("ucjs", ucs.selectOne(card_id));
		mav.setViewName("user/use-card/use-card-list");
		return mav;
	}

	@Override
	@GetMapping("/uc-form")
	public ModelAndView use_card_form(ModelAndView mav) {
		mav.addObject("cardDTOs", cs.selectAll());
		mav.setViewName("user/use-card/use-card-form");
		return mav;
	}

}
