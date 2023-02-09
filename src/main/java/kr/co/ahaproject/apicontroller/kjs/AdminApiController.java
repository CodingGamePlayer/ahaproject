package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.MisuDTO;
import org.springframework.http.ResponseEntity;

public interface AdminApiController {

    ResponseEntity register(MisuDTO misuDTO);

    ResponseEntity update(MisuDTO misuDTO);

    ResponseEntity delete(MisuDTO misuDTO);

    ResponseEntity changeAuth(AccountDTO accountDTO);

    ResponseEntity deleteAccount(AccountDTO accountDTO);




}
