package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.ClientDTO;
import org.springframework.http.ResponseEntity;

public interface ClientApiController {

    ResponseEntity register(ClientDTO clientDTO);

    ResponseEntity update(ClientDTO clientDTO);


}
