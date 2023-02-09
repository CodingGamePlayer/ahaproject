package kr.co.ahaproject.controller.cjw;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.dto.UseMaterialDTO;

public interface UseMaterialController {
	/* 기초정보 CRUD 작업 
     * 재원 23.02.08
     */ 
    
    // 현장 자재 정보 START ======
    
    // 현장 자재 전체목록 이동
    String list(Model model);
    
    // 현장 자재 글생성 이동
    String register();
    
    // 현장 자재 상세보기 이동
    String detail(UseMaterialDTO dto, Model model);

	
}
