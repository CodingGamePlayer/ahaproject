package kr.co.ahaproject.apicontroller.mskim;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.UseCardDTO;

public interface UseCardApiController {
	
	ResponseEntity register(UseCardDTO ucDTO);
	
	ResponseEntity update(UseCardDTO ucDTO);
	
	ResponseEntity delete(UseCardDTO ucDTO);

}
