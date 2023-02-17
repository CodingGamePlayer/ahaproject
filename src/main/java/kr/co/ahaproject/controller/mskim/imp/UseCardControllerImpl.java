package kr.co.ahaproject.controller.mskim.imp;


import kr.co.ahaproject.controller.mskim.UseCardController;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.service.mskim.CardService;
import kr.co.ahaproject.service.mskim.UseCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public String selectAll(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {

		PageResponseDTO<UseCardJoinDTO> pageResponseDTO = ucs.selectAllForPaging(pageRequestDTO);

		model.addAttribute("userCardJoinDTOs", pageResponseDTO);
		return "user/use-card/use-card-list";
	}

	@Override
	@GetMapping("/c-list")
	public ModelAndView selectOne(PageRequestDTO pageRequestDTO, ModelAndView mav, @RequestParam("card_id") int card_id) {
		
		
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

	@Override
	@GetMapping("/uc-edit")
	public ModelAndView getFindUcId(ModelAndView mav, @RequestParam("uc_id") int uc_id) {
		mav.addObject("ucinfo", ucs.getFindUcId(uc_id));
		mav.addObject("cardDTOs", cs.selectAll());
		mav.setViewName("user/use-card/use-edit-form");
		return mav;
	}



}
