package kr.co.ahaproject.apicontroller.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IncomeApiController {
    ResponseEntity register(IncomeOutcomeDTO ioDTO);

    ResponseEntity update(IncomeOutcomeDTO ioDTO);
    ResponseEntity delete(IncomeOutcomeDTO ioDTO);


}
