package kr.co.ahaproject.controller.jyh.imp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.ahaproject.controller.jyh.freeboardController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.service.jyh.freeboardService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/gboard/free-board")
public class freeboardControllerImpl implements freeboardController {

	@Autowired 
	freeboardService Freeboardservice;
	
	

	@Override
	@GetMapping("/list")
	public String listAll(Model model) {
		model.addAttribute("item", Freeboardservice.list());
		return "user/board/freeboard/freeboardlist";
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

	@Override
	@GetMapping("/register-form")
	public String createForm() {
		return "user/board/freeboard/register";
	}
}
