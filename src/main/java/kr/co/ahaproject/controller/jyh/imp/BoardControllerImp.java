package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.CategoryDTO;
import kr.co.ahaproject.service.jyh.BoardService;
import kr.co.ahaproject.service.jyh.CategoryService;
import kr.co.ahaproject.service.jyh.ReplyService;



@Controller
public class BoardControllerImp implements BoardController {
	
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyservice;
	

	

	

	// 공지사항
	@Override
	@GetMapping("user/gboard/list")
	public String list(Model model, BoardDTO dto) {

		model.addAttribute("listdata",service.listAll());

		return "user/board/list";
	}

	//등록페이지 이동
	@Override
	@GetMapping("user/board/register")
	public String create(Model model, BoardDTO dto) {
		model.addAttribute("register", service.SelectOne(dto.getCt_id()));
		return "user/board/register";
	}
	
	//게시판 상세보기페이지로 이동
	
	@Override
	@GetMapping("/user/board/SelectOne/{b_id}")
	public String detail(@PathVariable("b_id") int b_id, Model model) {
		
		model.addAttribute("selectdata", service.SelectOne(b_id));
		model.addAttribute("replydata",replyservice.getdetail(b_id));
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
