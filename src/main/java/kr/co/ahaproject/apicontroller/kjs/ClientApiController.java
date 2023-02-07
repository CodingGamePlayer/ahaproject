package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.http.ResponseEntity;

public interface ClientApiController {

    ResponseEntity register(ClientDTO clientDTO);

    ResponseEntity update(ClientDTO clientDTO);


}
