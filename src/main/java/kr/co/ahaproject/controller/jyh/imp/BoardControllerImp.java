package kr.co.ahaproject.controller.jyh.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.CategoryDTO;
import kr.co.ahaproject.service.jyh.BoardService;

@Controller
public class BoardControllerImp implements BoardController {
	
	
	@Autowired
	private BoardService service;


	@Override
	@GetMapping("user/gboard/list")// 공지사항
	public String list(Model model) {
		
		model.addAttribute("listdata",service.listAll());
		
		return "user/board/list";
	}

	//등록페이지 이동
	@Override
	@GetMapping("/user/board/register")
	public String create() {

		
		
		return "user/board/register";
	}
	
	



}
