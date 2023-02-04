package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.AccountApiController;
import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class AccountApiControllerImp implements AccountApiController {


    @Autowired
    private AccountService accountService;


    @Override
    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@RequestBody AccountDTO accountDTO) {

        log.info("input DTO : " + accountDTO);
        int result = accountService.register(accountDTO);
        log.info("result : " + result);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
