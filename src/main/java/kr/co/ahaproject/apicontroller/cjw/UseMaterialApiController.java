package kr.co.ahaproject.apicontroller.cjw;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.dto.UseMaterialDTO;

public interface UseMaterialApiController {
		// 현장 자재 글생성
		ResponseEntity register(UseMaterialDTO useMaterialDTO);
		
		// 현장 자재 글수정
		ResponseEntity update(UseMaterialDTO useMaterialDTO);
		
		// 현장 글삭제
		ResponseEntity delete(UseMaterialDTO useMaterialDTO);
		
}
