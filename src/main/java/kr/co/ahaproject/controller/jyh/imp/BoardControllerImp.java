package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.service.jyh.BoardService;

@Controller
public class BoardControllerImp implements BoardController {
	
	
	@Autowired
	private BoardService service;


	@Override
	@GetMapping("user/gboard/list")// 자유게시판
	public String list(Model model) {
		
		model.addAttribute("listdata", service.listAll());
		
		return "user/board/list";
	}



}
