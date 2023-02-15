package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.jyh.ReplyController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.service.jyh.BoardService;
import kr.co.ahaproject.service.jyh.ReplyService;

@Controller
public class ReplyControllerImpl implements ReplyController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;


	@Override
	@GetMapping("/user/board/reply/{b_id}")
	public String list(Model model, ReplyDTO dto) {
		model.addAttribute("replydata",replyService.getdetail(dto.getB_id()));
		return "user/board/reply";
	}

	//등록페이지 이동
	@Override
	@GetMapping("/user/board/replyregister")
	public String create(Model model, BoardDTO boardDTO,ReplyDTO ReplyDto) {
		model.addAttribute("update", boardService.SelectOne(boardDTO.getB_id()));
	
		return "user/board/replyregister";
	}

	//수정페이지 이동
	@Override
	@GetMapping("/user/board/replyupdate")
	public String detail(Model model, ReplyDTO dto) {
		model.addAttribute("usedata", replyService.SelectOne(dto.getRp_id()));
		return "user/board/replyupdate";
	}

}
