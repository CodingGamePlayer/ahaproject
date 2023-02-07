package kr.co.ahaproject.controller.cjw;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.MaterialDTO;

public interface MaterialController {
	
	 /* 기초정보 CRUD 작업 
     * 재원 23.02.07
     * dd
     */ 
    
    // 자재 기초정보 START ======
    
    // 자재 기초정보 전체목록
    String list(Model model);
    
    // 자재 기초정보 글생성
    String register();
    
    // 자재 기초정보 글생성 처리
    String registerPro(MaterialDTO dto);
    
    // 자재 기초정보 상세보기
    String detail();
    
    // 자재 기초정보 수정
    String update();
    
    // 자재 기초정보 수정처리
    String updatePro();
    
    // 자재 기초정보 삭제
    String delete();

	
    
    // 자재 기초정보 END ======
}
