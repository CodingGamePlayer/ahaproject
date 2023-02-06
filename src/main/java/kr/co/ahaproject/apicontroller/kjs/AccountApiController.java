package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import org.springframework.http.ResponseEntity;

public interface AccountApiController {

    ResponseEntity<AccountDTO> register(AccountDTO accountDTO);


}
