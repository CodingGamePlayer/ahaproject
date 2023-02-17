package kr.co.ahaproject.controller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ahaproject.controller.mskim.ConReplyController;
import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.service.mskim.ConReplyService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/user/worksite/con-reply")
public class ConReplyControllerImpl implements ConReplyController{
	
	@Autowired
	private ConReplyService conReplyService;
	
	@Autowired
	private ConstructionService constructionService;
	
	

	@Override
	@GetMapping("/con-reply-list")
	public ModelAndView selectAll(PageRequestDTO pageRequestDTO, ModelAndView mav) {
		PageResponseDTO<ConReplyDTO> pageResponseDTO= conReplyService.selectAllForPaging(pageRequestDTO);
		mav.addObject("conReplyDTOs", pageResponseDTO);
		mav.setViewName("user/con-reply/con-reply-list");
		
		return mav;
	}



	@Override
	@GetMapping("/con-reply-form")
	public ModelAndView registForm(ModelAndView mav) {
		
		mav.addObject("cstDTOs", constructionService.selectAll());
		mav.setViewName("user/con-reply/con-reply-form");
		
		return mav;
	}



	@Override
	@GetMapping("/con-reply-edit")
	public ModelAndView editForm(ModelAndView mav, ConReplyDTO conReplyDTO) {
		
		mav.addObject("cstDTOs", constructionService.selectAll());
		mav.addObject("crDTO", conReplyService.selectOne(conReplyDTO));
		mav.setViewName("user/con-reply/con-reply-edit");
		
		return mav;
	}

}
