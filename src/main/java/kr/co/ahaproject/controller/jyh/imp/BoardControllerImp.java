package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.dto.BoardDTO;
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
	
	//게시판 상세보기페이지로 이동
	@Override
	@GetMapping("/user/board/SelectOne/{b_id}")
	public String detail(Model model ,BoardDTO dto) {
		
		model.addAttribute("selectdata", service.SelectOne(dto.getB_id()));
		return "user/board/board-detail";
	}

	//게시판 업데이트 페이지로 이동
	@Override
	@GetMapping("/user/board/detail")
	public String update(Model model, BoardDTO dto) {
		
		model.addAttribute("update", service.SelectOne(dto.getB_id()));
		return "user/board/board-edit-form";
	}
	
	
	
	
	
	
	



}
