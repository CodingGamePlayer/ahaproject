package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.moo.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MachineServiceImpTest {
    @Autowired
    private MachineService machineService;

    @Test
    void register() {

        MachineDTO machineDTO = MachineDTO.builder()
                .m_code("MC0000")
                .m_name("츄레라")
                .m_equip_num("103023")
                .m_type("자사")
                .m_kind("장비")
                .m_price(10000L)
                .m_tax(1000L)
                .m_date("2023. 02. 01")
                .build();

        int register = machineService.register(machineDTO);

        log.info(String.valueOf(register));
    }
}