package kr.co.ahaproject.controller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.ConstructionController;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.mskim.ConstructionService;


@Controller
@RequestMapping("/user/worksite/construction")
public class ConstructionControllerImpl implements ConstructionController {

	@Autowired
	private ConstructionService constructionService;
	
	@Override
	@GetMapping("/cst-list")
	public ModelAndView construction(ModelAndView mav) {
		
		mav.addObject("constructionDTOs", constructionService.selectAll());
		mav.setViewName("user/construction/construction-list");
		
		return mav;
	}

	@Override
	@GetMapping("/cst-form")
	public String construction_form() {
		
		return "user/construction/construction-form";
	}

	@Override
	@GetMapping("/cst-edit")
	public ModelAndView construction_edit(ModelAndView mav, ConstructionDTO cstDTO) {
		mav.addObject("cstDTO", constructionService.findByCst(cstDTO));
		mav.setViewName("user/construction/construction-edit-form");
		
		return mav;
	}

}
