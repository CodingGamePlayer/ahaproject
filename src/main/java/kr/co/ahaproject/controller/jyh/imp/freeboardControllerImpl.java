package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.ahaproject.controller.jyh.freeboardController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.service.jyh.freeboardService;

@Controller
public class freeboardControllerImpl implements freeboardController {

	@Autowired 
	freeboardService Freeboardservice;
	
	

	@Override
	@GetMapping("/user/freeboard/freeboardlist")
	public String listAll(Model model) {
		model.addAttribute("item", Freeboardservice.list());
		return "user/board/freeboard/freeboardlist";
	}

	@Override
	@GetMapping("/user/board/freeboard/freeregister")
	public String create() {
		// TODO Auto-generated method stub
		return "user/board/freeboard/freeboardregister";
	}

	@Override
	public String detail(int b_id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Model model, BoardDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
