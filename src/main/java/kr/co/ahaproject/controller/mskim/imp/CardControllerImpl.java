package kr.co.ahaproject.controller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.CardController;
import kr.co.ahaproject.service.mskim.CardService;

@Controller
public class CardControllerImpl implements CardController {
	
	@Autowired
	private CardService cardService;

	@Override
	@GetMapping("/user/basicinfo/card")
	public ModelAndView card(ModelAndView mav) {
		
		mav.addObject("cardDTOs", cardService.selectAll());
		mav.setViewName("user/card/cardlist");
		
		return mav;
	}

	@Override
	@GetMapping("/user/basicinfo/card/{cl_code}")
	public ModelAndView cardClient(ModelAndView mav, @RequestParam("cl_code") String cl_code) {
		
		mav.addObject("cardDTOs", cardService.findBYClient(cl_code));
		mav.setViewName("user/card/cardlist");
		return mav;
	}

	@Override
	@GetMapping("/user/basicinfo/card-form")
	public String card_form() {
		return "user/card/card-form";
	}

	@Override
	@GetMapping("/user/basicinfo/card-edit")
	public ModelAndView card_edit(ModelAndView mav, @RequestParam("card_id") int card_id) {
		mav.addObject("cardDTO", cardService.findByCard(card_id));
		mav.setViewName("user/card/card-edit-form");
		return mav;
	}
	

}
