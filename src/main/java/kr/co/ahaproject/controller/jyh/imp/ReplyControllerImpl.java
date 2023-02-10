package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.jyh.ReplyController;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.service.jyh.ReplyService;

@Controller
public class ReplyControllerImpl implements ReplyController {
	
	@Autowired
	private ReplyService service;

	@Override
	@GetMapping("/user/board/reply/{b_id}")
	public String list(Model model, ReplyDTO dto) {
		model.addAttribute("replydata",service.getdetail(dto.getB_id()));
		return "user/board/reply";
	}

	//등록페이지 이동
	@Override
	@GetMapping("/user/board/replyregister")
	public String create(Model model, ReplyDTO dto) {
		model.addAttribute("data", service.getdetail(dto.getB_id()));
		return "/user/board/replyregister";
	}

	@Override
	public String detail(Model model, ReplyDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
