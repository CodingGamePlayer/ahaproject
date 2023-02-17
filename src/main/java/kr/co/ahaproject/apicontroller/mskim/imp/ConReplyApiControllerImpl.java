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
import kr.co.ahaproject.apicontroller.mskim.ConReplyApiController;
import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.service.mskim.ConReplyService;

@RestController
@RequestMapping("/api/user/worksite/con-reply")
public class ConReplyApiControllerImpl implements ConReplyApiController {

	@Autowired
	private ConReplyService conReplyService;
	
	@Override
	@ApiOperation(value="공사요청 POST", notes="fetch를 이용하오 POST방식으로 요청사항 등록")
	@PostMapping(value="/crinfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConReplyDTO> regist(@RequestBody ConReplyDTO conReplyDTO) {
		
		if(conReplyDTO ==null) {
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = conReplyService.regist(conReplyDTO);
		
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

	@Override
	@ApiOperation(value="공사요청 PUT", notes="fetch를 이용하여 PUT방식으로 공사요청 수정")
	@PutMapping(value="/crinfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConReplyDTO> update(@RequestBody ConReplyDTO conReplyDTO) {
		
		if(conReplyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = conReplyService.update(conReplyDTO);
		
		if(!(result>0)) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="공사요청 DELETE", notes="fetch를 이용하여 DELETE방식으로 공사요청 삭제")
	@DeleteMapping(value="/crinfo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConReplyDTO> delete(@RequestBody ConReplyDTO conReplyDTO) {
		
		if(conReplyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		int result = conReplyService.delete(conReplyDTO);
		
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

}
