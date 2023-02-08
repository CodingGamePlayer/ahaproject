package kr.co.ahaproject.apicontroller.cjw;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.MaterialDTO;

public interface MaterialApiController {
	// 자재 기초등록 글생성
	ResponseEntity register(MaterialDTO materialDTO);
	
	// 자재 기초등록 글수정
	ResponseEntity update(MaterialDTO materialDTO);
	
	// 자재 기초등록 글삭제
	ResponseEntity delete(MaterialDTO materialDTO);
	
	
}
