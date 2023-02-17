package kr.co.ahaproject.controller.jyh.imp;

import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.service.jyh.BoardService;
import kr.co.ahaproject.service.jyh.CategoryService;
import kr.co.ahaproject.service.jyh.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardControllerImp implements BoardController {

	private final CategoryService categoryService;
	private final BoardService boardService;

	private final ReplyService replyService;


	// 공지사항
	@Override
	@GetMapping("/user/board/list")
	public String list(PageRequestDTO pageRequestDTO, Model model) {

		PageResponseDTO<BoardListDTO> pageResponseDTO = boardService.selectAllForPaging(pageRequestDTO);

		model.addAttribute("boards", pageResponseDTO);

		return "user/board/list";
	}

	@Override
	@GetMapping("/user/board/list-qna")
	public String listQnA(PageRequestDTO pageRequestDTO, Model model) {

		PageResponseDTO<BoardListDTO> pageResponseDTO = boardService.selectAllForPaging(pageRequestDTO);

		model.addAttribute("boards", pageResponseDTO);

		return "user/board/list-qna";
	}

	//등록페이지 이동
	@Override
	@GetMapping("/user/board/register-form")
	public String create(Model model, BoardDTO dto) {
		List<CategoryDTO> categoryDTOS = categoryService.listAll();

		model.addAttribute("categories", categoryDTOS);
		return "user/board/register";
	}

	@Override
	@GetMapping("/user/board/register-qna-form")
	public String createQnA(Model model, BoardDTO dto) {
		List<CategoryDTO> categoryDTOS = categoryService.listAll();

		model.addAttribute("categories", categoryDTOS);
		return "user/board/register-qna";
	}

	//게시판 업데이트 페이지로 이동
	@Override
	@GetMapping("/user/board/detail/{id}")
	public String detail(@PathVariable int id, Model model, @AuthenticationPrincipal Account account) {


		BoardDTO boardDTO = boardService.SelectOne(id);
		List<CategoryDTO> categoryDTOS = categoryService.listAll();
		List<ReplyListDTO> replyDTOS = replyService.findByBoardId(id);

		model.addAttribute("replies", replyDTOS);
		model.addAttribute("account", account);
		model.addAttribute("board", boardDTO);
		model.addAttribute("categories", categoryDTOS);

		return "user/board/detail";
	}

	@Override
	@GetMapping("/user/board/detail-qna/{id}")
	public String detailQnA(@PathVariable int id, Model model, @AuthenticationPrincipal Account account) {


		BoardDTO boardDTO = boardService.SelectOne(id);
		List<CategoryDTO> categoryDTOS = categoryService.listAll();
		List<ReplyListDTO> replyDTOS = replyService.findByBoardId(id);

		model.addAttribute("replies", replyDTOS);
		model.addAttribute("account", account);
		model.addAttribute("board", boardDTO);
		model.addAttribute("categories", categoryDTOS);

		return "user/board/detail-qna";
	}
}
