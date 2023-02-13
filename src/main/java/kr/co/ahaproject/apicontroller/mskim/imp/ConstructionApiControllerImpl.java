package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.mskim.ConstructionApiController;
import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.mskim.ConstructionService2;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user/worksite/construction")
@Slf4j
public class ConstructionApiControllerImpl implements ConstructionApiController{

	@Autowired
	private ConstructionService2 cstService;
	
	@Override
	@ApiOperation(value="공사 POST", notes="fetch를 이용하여 POST방식으로 공사정보 등록")
	@PostMapping(value="/cstinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConstructionDTO> register(@RequestBody ConstructionDTO cstDTO) {
		
		String after = new AhaCommonMethod().changeDate(cstDTO.getCst_start());
		cstDTO.setCst_start(after);
		after = new AhaCommonMethod().changeDate(cstDTO.getCst_end());
		cstDTO.setCst_end(after);
		
		if(cstDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cstService.regist(cstDTO);
		
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="공사 PUT", notes="fetch를 이용하여 PUT방식으로 공사정보 수정")
	@PutMapping(value="/cstinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConstructionDTO> update(@RequestBody ConstructionDTO cstDTO) {
		
		if(cstDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cstService.update(cstDTO);
		
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="공사 DELET", notes="fetch를 이용하여 DELET방식으로 공사정보 삭제")
	@DeleteMapping(value="/cstinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConstructionDTO> delete(@RequestBody ConstructionDTO cstDTO) {
		
		if(cstDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cstService.delete(cstDTO);
		
		if(!(result > 0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
