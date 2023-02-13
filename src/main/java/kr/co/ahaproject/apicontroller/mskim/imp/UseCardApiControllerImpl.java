package kr.co.ahaproject.apicontroller.mskim.imp;

import org.apache.ibatis.annotations.Delete;
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
import kr.co.ahaproject.apicontroller.mskim.UseCardApiController;
import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.mskim.UseCardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user/worksite/use-card")
public class UseCardApiControllerImpl implements UseCardApiController {
	
	@Autowired
	private UseCardService ucs;

	@Override
	@ApiOperation(value = "카드사용 POST", notes="fetch를 이용하여 POST방식으로 카드사용정보 등록")
	@PostMapping(value = "/ucinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UseCardDTO> register(@RequestBody UseCardDTO ucDTO) {
		
		
		if(ucDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		String after = new AhaCommonMethod().changeDate(ucDTO.getUc_date());
		ucDTO.setUc_date(after);
		
		int result = ucs.regist(ucDTO);
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value = "카드사용 PUT", notes="fetch를 이용하여 PUT방식으로 카드사용정보 수정")
	@PutMapping(value="/ucinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UseCardDTO> update(@RequestBody UseCardDTO ucDTO) {
		
		if(ucDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		String after = new AhaCommonMethod().changeDate(ucDTO.getUc_date());
		ucDTO.setUc_date(after);
		
		int result = ucs.update(ucDTO);
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="카드사용 DELETE", notes="fetch를 이용하여 DELETE방식으로 카드사용정보 삭제")
	@DeleteMapping(value="/ucinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UseCardDTO> delete(@RequestBody UseCardDTO ucDTO) {
		
		if(ucDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		int result = ucs.delete(ucDTO);
		
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
