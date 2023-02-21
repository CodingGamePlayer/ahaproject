package kr.co.ahaproject.controller.mskim.imp;

import kr.co.ahaproject.controller.mskim.CardController;
import kr.co.ahaproject.dto.CardDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.mskim.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/basicinfo/card")
public class CardControllerImpl implements CardController {
	
	@Autowired
	private CardService cardService;

	@Autowired
	private ClientService clientService;

	@Override
	@GetMapping("/card-list")
	public String card(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
		PageResponseDTO<CardDTO> pageResponseDTO = cardService.selectAllForPaging(pageRequestDTO);

		model.addAttribute("cards", pageResponseDTO);
		return "user/card/card-list";
	}

	@Override
	@GetMapping("/card-list/{cl_code}")
	public ModelAndView cardClient(ModelAndView mav, @RequestParam("cl_code") String cl_code) {
		
		mav.addObject("cardDTOs", cardService.findBYClient(cl_code));
		mav.setViewName("user/card/card-list");
		return mav;
	}

	@Override
	@GetMapping("/card-form")
	public String card_form(Model model) {

		model.addAttribute("clients", clientService.selectAll());

		return "user/card/card-form";
	}

	@Override
	@GetMapping("/card-edit")
	public ModelAndView card_edit(ModelAndView mav, @RequestParam("card_id") int card_id) {
		mav.addObject("cardDTO", cardService.findByCard(card_id));
		mav.addObject("clients", clientService.selectAll());
		mav.setViewName("user/card/card-edit-form");
		return mav;
	}
	

}
