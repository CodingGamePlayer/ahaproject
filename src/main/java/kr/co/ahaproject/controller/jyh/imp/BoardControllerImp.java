package kr.co.ahaproject.controller.jyh.imp;

import kr.co.ahaproject.controller.jyh.BoardController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.service.jyh.BoardService;
import kr.co.ahaproject.service.jyh.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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


	// 공지사항
	@Override
	@GetMapping("/user/board/list")
	public String list(PageRequestDTO pageRequestDTO, Model model) {

		PageResponseDTO<BoardListDTO> pageResponseDTO = boardService.selectAllForPaging(pageRequestDTO);

		model.addAttribute("boards", pageResponseDTO);

		return "user/board/list";
	}

	//등록페이지 이동
	@Override
	@GetMapping("/user/board/register-form")
	public String create(Model model, BoardDTO dto) {
		List<CategoryDTO> categoryDTOS = categoryService.listAll();

		model.addAttribute("categories", categoryDTOS);
		return "user/board/register";
	}
	
	//게시판 상세보기페이지로 이동
	
	@Override
	@GetMapping("/user/board/SelectOne/{b_id}")
	public String detail(@PathVariable("b_id") int b_id, Model model) {

		return "user/board/board-detail";
	}

	//게시판 업데이트 페이지로 이동
	@Override
	@GetMapping("/user/board/detail/{id}")
	public String update(@PathVariable int id, Model model) {

		BoardDTO boardDTO = boardService.SelectOne(id);
		List<CategoryDTO> categoryDTOS = categoryService.listAll();


		model.addAttribute("board", boardDTO);
		model.addAttribute("categories", categoryDTOS);

		return "user/board/detail";
	}
	
	


	

	
	
	
	
	
	
	

	
	
	
	
	
	
	



}
