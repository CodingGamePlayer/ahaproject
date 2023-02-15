package kr.co.ahaproject.apicontroller.jyh;

import org.springframework.http.ResponseEntity;
import kr.co.ahaproject.dto.ReplyDTO;

public interface ReplyApiController {
	ResponseEntity create(ReplyDTO dto);

	 ResponseEntity update(ReplyDTO dto);
	
	 ResponseEntity delete(ReplyDTO dto);

}
