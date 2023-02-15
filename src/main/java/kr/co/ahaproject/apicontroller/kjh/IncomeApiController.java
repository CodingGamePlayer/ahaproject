package kr.co.ahaproject.apicontroller.kjh;

import kr.co.ahaproject.dto.IncomeDTO;
import org.springframework.http.ResponseEntity;

public interface IncomeApiController {
    ResponseEntity register(IncomeDTO inDTO);

    ResponseEntity update(IncomeDTO inDTO);
    ResponseEntity delete(IncomeDTO inDTO);


}

