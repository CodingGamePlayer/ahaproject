package kr.co.ahaproject.apicontroller.moo;

import kr.co.ahaproject.dto.LaborCostDTO;
import org.springframework.http.ResponseEntity;

public interface LaborCostApiController {
    ResponseEntity register(LaborCostDTO laborCostDTO);

    ResponseEntity update(LaborCostDTO laborCostDTO);

    ResponseEntity delete(LaborCostDTO laborCostDTO);
}
