package kr.co.ahaproject.apicontroller.jyh;

import kr.co.ahaproject.dto.ReplyDTO;
import org.springframework.http.ResponseEntity;

public interface ReplyApiController {

    public ResponseEntity insert(ReplyDTO replyDTO);

    public ResponseEntity delete(ReplyDTO replyDTO);
}
