package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.http.ResponseEntity;

public interface AdminApiController {

    ResponseEntity register(MisuDTO misuDTO);

}
