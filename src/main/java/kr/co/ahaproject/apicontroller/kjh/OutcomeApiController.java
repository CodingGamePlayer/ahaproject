package kr.co.ahaproject.apicontroller.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import org.springframework.http.ResponseEntity;

public interface OutcomeApiController {
    ResponseEntity register(IncomeOutcomeDTO ioDTO);

    ResponseEntity update(IncomeOutcomeDTO ioDTO);
    ResponseEntity delete(IncomeOutcomeDTO ioDTO);
}
