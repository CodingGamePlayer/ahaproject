package kr.co.ahaproject.controller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.ConstructionController;
import kr.co.ahaproject.service.mskim.ConstructionService2;


@Controller
public class ConstructionControllerImpl implements ConstructionController {

	@Autowired
	private ConstructionService2 constructionService;
	
	@Override
	@GetMapping("/user/worksite/construction")
	public ModelAndView construction(ModelAndView mav) {
		
		mav.addObject("constructionDTOs", constructionService.selectAll());
		mav.setViewName("user/construction/construction-list");
		
		return mav;
	}

	@Override
	public String construction_form() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView construction_edit(ModelAndView mav, int cst_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
