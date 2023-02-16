package kr.co.ahaproject.apicontroller.jungi.impl;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.jungi.BillingApiController;
import kr.co.ahaproject.dto.BillingDTO;
import kr.co.ahaproject.dto.CardDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.jungi.BillingService;
import kr.co.ahaproject.service.mskim.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/basicinfo/billing")
public class BillingApiControllerImpl implements BillingApiController {

    private BillingService billingService;

    @Override
    @ApiOperation(value="견적서 POST", notes="fetch를 이용하여 POST방식으로 견적서 정보 등록" )
    @PostMapping(value="/billingInfo", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingDTO> register(@RequestBody BillingDTO billingDTO) {

        return getBillingDTOResponseEntity(billingDTO == null, billingService.register(billingDTO), billingDTO);
    }

    @Override
    @ApiOperation(value="견적서 PUT", notes="fetch를 이용하여 PUT방식으로 견적서 정보 수정")
    @PutMapping(value="/billingInfo", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingDTO> update(@RequestBody BillingDTO billingDTO) {

        return getBillingDTOResponseEntity(billingDTO == null, billingService.update(billingDTO), billingDTO);
    }

    @Override
    @ApiOperation(value="견적서 DELETE", notes="fetch를 이용하여 DELETE 방식으로 견적서 정보 삭제")
    @DeleteMapping(value="/billingInfo", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BillingDTO> delete(@RequestBody BillingDTO billingDTO) {

        return getBillingDTOResponseEntity(billingDTO == null, billingService.delete(billingDTO), billingDTO);
    }

    public ResponseEntity<BillingDTO> getBillingDTOResponseEntity(boolean b, int register, @RequestBody BillingDTO billingDTO) {
        if(b) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        int result = register;

        if(result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Autowired
    public BillingApiControllerImpl(BillingService billingService) {
        this.billingService = billingService;
    }
}
