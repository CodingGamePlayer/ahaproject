package kr.co.ahaproject.apicontroller.mskim;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.CardDTO;

public interface CardApiController {
	
	ResponseEntity register(CardDTO cardDTO);
	
	ResponseEntity update(CardDTO cardDTO);
	

}
