package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.mskim.ConstructionApiController;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.mskim.ConstructionService2;

@RestController
@RequestMapping("/api/user/worksite/construction")
public class ConstructionApiControllerImpl implements ConstructionApiController{

	@Autowired
	private ConstructionService2 cstService;
	
	@Override
	public ResponseEntity<ConstructionDTO> register(ConstructionDTO cstDTO) {
		
		if(cstDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = 0;
		
		return null;
	}

	@Override
	public ResponseEntity<ConstructionDTO> update(ConstructionDTO cstDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ConstructionDTO> delete(ConstructionDTO cstDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
