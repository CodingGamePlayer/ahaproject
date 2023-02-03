package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class AccountServiceImpTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void register() {

        AccountDTO accountDTO = AccountDTO.builder()
                .cp_name("김회사")
                .ac_password("123")
                .username("otw1917")
                .ac_person_name("김길동")
                .build();

        int result = accountService.register(accountDTO);
        log.info("AccountDTO : {}", accountDTO);
        log.info(String.valueOf(result));

    }

    @Test
    void findByUsername() {


        AccountDTO result = accountService.findByUsername("user");

        log.info("account : " + result);
    }
}