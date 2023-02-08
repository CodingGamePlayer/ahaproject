package kr.co.ahaproject.controller.cjw.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ahaproject.controller.cjw.MaterialController;
import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.service.cjw.MaterialService;

@Controller
public class MaterialControllerImp implements MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
    
    /*		자재 기초정보 CRUD
            작업자 : 재원 23.02.07       */
    
    // 자재 기초정보 START ==============
    
    // 자재 기초정보 전체글보기
	@Override
	@GetMapping("/user/material/list")
	public String list(Model model) {
		model.addAttribute("listData", materialService.listAll());
		return "/user/material/material";
	}
	
	// 자재 기초정보 글생성 이동
	@Override
	@GetMapping("/user/material/register")
	public String register() {
		
		return "/user/material/material-form";
	}
	
	// 자재 기초정보 글생성 처리
	@Override
	@PostMapping("/user/material/registerPro")
	public String registerPro(MaterialDTO dto) {
		materialService.create(dto);
		return null;
	}
	
	// 자재 기초정보 상세보기 페이지 이동
	@Override
	@GetMapping("/user/material/detail")
	public String detail(MaterialDTO dto ,Model model) {
		
		model.addAttribute("selectData", materialService.selectOne(dto.getMt_id()));
		return "/user/material/material-edit-form";
	}

	// 자재 기초정보 상세보기 페이지 → 수정처리해주기
	@Override
	public String updatePro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}



	



	
	
	// 자재 기초정보 END ======

	
}
