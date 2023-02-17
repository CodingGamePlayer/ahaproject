package kr.co.ahaproject.apicontroller.mskim;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.ConReplyDTO;

public interface ConReplyApiController {
	
	ResponseEntity regist(ConReplyDTO conReplyDTO);
	
	ResponseEntity update(ConReplyDTO conReplyDTO);
	
	ResponseEntity delete(ConReplyDTO conReplyDTO);

}
