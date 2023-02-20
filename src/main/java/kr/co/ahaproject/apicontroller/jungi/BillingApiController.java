package kr.co.ahaproject.apicontroller.jungi;

import kr.co.ahaproject.dto.BillingDTO;
import kr.co.ahaproject.dto.CardDTO;
import org.springframework.http.ResponseEntity;

public interface BillingApiController {

    ResponseEntity register(BillingDTO billingDTO);

    ResponseEntity update(BillingDTO billingDTO);

    ResponseEntity delete(BillingDTO billingDTO);

}
