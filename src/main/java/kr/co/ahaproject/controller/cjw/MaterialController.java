package kr.co.ahaproject.controller.cjw;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.MaterialDTO;

public interface MaterialController { 
	
	 /* 기초정보 CRUD 작업 
     * 재원 23.02.07
     */ 
    
    // 자재 기초정보 START ======
    
    // 자재 기초정보 전체목록 이동
    String list(Model model);
   
    // 자재 기초정보 글생성 이동
//    String register(Model model);
    
    String register(Model model, MaterialDTO dto);
    // 자재 기초정보 상세보기 이동
    String detail(MaterialDTO dto, Model model);

	

	



	


	

	

	

	

	

	

	
    
    // 자재 기초정보 END ======
}
