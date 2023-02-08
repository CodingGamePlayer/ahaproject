package kr.co.ahaproject.controller.cjw.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping("/user/basicinfo/material/list")
	public String list(Model model) {
		
		return null;
	}
	
	// 자재 기초정보 글생성 이동
	@Override
	@GetMapping("/user/basicinfo/material/register")
	public String register() {
			
		return null;
	}
	
	// 자재 기초정보 글생성 처리
	@Override
	@PostMapping("/user/basicinfo/material/registerPro")
	public String registerPro(MaterialDTO dto) {
		
		return null;
	}

	@Override
	public String detail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
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
