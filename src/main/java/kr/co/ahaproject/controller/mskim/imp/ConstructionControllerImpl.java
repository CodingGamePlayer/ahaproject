package kr.co.ahaproject.controller.mskim.imp;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.ConstructionController;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.mskim.ConstructionService;

import javax.validation.Valid;


@Controller
@RequestMapping("/user/worksite/construction")
public class ConstructionControllerImpl implements ConstructionController {
//
	@Autowired
	private ConstructionService constructionService;
	
	@Override
	@GetMapping("/cst-list")
	public ModelAndView construction(@Valid PageRequestDTO pageRequestDTO, ModelAndView mav) {

		PageResponseDTO<ConstructionDTO> pageResponseDTO = constructionService.selectAllForPaging(pageRequestDTO);

		mav.addObject("constructionDTOs", pageResponseDTO);
		mav.setViewName("user/construction/construction-list");

		return mav;
	}

	@Override
	@GetMapping("/cst-form")
	public ModelAndView construction_form(ModelAndView mav) {
		int count = constructionService.codeCount();
		
		if(count >0) {
			String code = String.format("%04d",count+1);
			mav.addObject("ConstructionCode", "CS"+code);
		} else {
			mav.addObject("ConstructionCode", "CS0001");
		}
		
		mav.setViewName("user/construction/construction-form");
		return mav;
	}

	@Override
	@GetMapping("/cst-edit")
	public ModelAndView construction_edit(ModelAndView mav, ConstructionDTO cstDTO) {
		mav.addObject("cstDTO", constructionService.findByCst(cstDTO));
		mav.setViewName("user/construction/construction-edit-form");
		
		return mav;
	}

}
