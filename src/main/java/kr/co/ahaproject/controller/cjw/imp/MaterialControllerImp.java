package kr.co.ahaproject.controller.cjw.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.cjw.MaterialController;
import kr.co.ahaproject.dto.MachineDTO;
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
	public String register(Model model, MaterialDTO dto) {

	    if(materialService.selectCount() > 0) {
	        int id = materialService.selectCount() + 1;
	        String idkey = String.format("%04d",id);
	        model.addAttribute("idkey", "MT"+idkey);
	    } else {
	        String idkey = "0001";
	        model.addAttribute("idkey","MT"+idkey);
	    }
		
		
		
		

		return "/user/material/material-form";
	}

	
	// 자재 기초정보 상세보기 페이지 이동
	@Override
	@GetMapping("/user/material/detail")
	public String detail(MaterialDTO dto ,Model model) {
		
		model.addAttribute("selectData", materialService.selectOne(dto.getMt_id()));
		return "/user/material/material-edit-form";
	}





	



	
	
	// 자재 기초정보 END ======

	
}
