package kr.co.ahaproject.apicontroller.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.http.ResponseEntity;

public interface IncomeApiController {
    ResponseEntity register(IncomeOutcomeDTO ioDTO);

    ResponseEntity update(IncomeOutcomeDTO ioDTO);
}
