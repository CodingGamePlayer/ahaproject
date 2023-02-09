package kr.co.ahaproject.apicontroller.mskim;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.ConstructionDTO;

public interface ConstructionApiController {
	
	ResponseEntity register(ConstructionDTO cstDTO);
	
	ResponseEntity update(ConstructionDTO cstDTO);
	
	ResponseEntity delete(ConstructionDTO cstDTO);

}
