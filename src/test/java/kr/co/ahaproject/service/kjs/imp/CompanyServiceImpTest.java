package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class CompanyServiceImpTest {

    @Autowired
    private CompanyService companyService;

    @Test
    void selectAll() {

        List<CompanyDTO> companyDTOS = companyService.selectAll();

        companyDTOS.forEach(companyDTO -> log.info(String.valueOf(companyDTO)));

    }
}