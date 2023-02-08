package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.CompanyDTO;

import org.springframework.http.ResponseEntity;

public interface CompanyApiController {

    ResponseEntity register(CompanyDTO companyDTO);

    ResponseEntity update(CompanyDTO companyDTO);
    
    ResponseEntity delete(CompanyDTO companyDTO);


}
