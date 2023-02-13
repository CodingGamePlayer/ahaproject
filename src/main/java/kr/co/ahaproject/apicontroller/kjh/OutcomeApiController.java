package kr.co.ahaproject.apicontroller.kjh;

import kr.co.ahaproject.dto.OutcomeDTO;
import org.springframework.http.ResponseEntity;

public interface OutcomeApiController {
    ResponseEntity register(OutcomeDTO outDTO);

    ResponseEntity update(OutcomeDTO outDTO);
    ResponseEntity delete(OutcomeDTO outDTO);
}
