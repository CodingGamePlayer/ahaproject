package kr.co.ahaproject.controller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.jyh.CategoryboardController;

import kr.co.ahaproject.dto.CategoryDTO;
import kr.co.ahaproject.service.jyh.CategoryService;

@Controller
public class CategoryboardControllerImpl implements CategoryboardController{
	
	@Autowired
	CategoryService service;

	@Override
	@GetMapping("/user/category/list")
	public String list(Model model) {
		model.addAttribute("categorydata", service.listAll());
		return "user/board/categoryboard/categoryboard";
	}

	@Override
	@GetMapping("/user/board/categoryboard/register")
	public String create() {
		// TODO Auto-generated method stub
		return "user/board/categoryboard/category-form";
	}

	@Override
	public String detail(int b_id, Model model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@GetMapping("/user/categoryboard/category-detail{ct_id}")
	public String update(Model model, CategoryDTO dto) {
		model.addAttribute("update", service.SelectOne(dto.getCt_id()));
		return "user/board/categoryboard/category-edit";
	}

	@Override
	public String delete(int ct_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
