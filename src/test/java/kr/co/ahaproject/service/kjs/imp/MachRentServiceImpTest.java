package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.service.kjs.MachRentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MachRentServiceImpTest {

    @Autowired
    private MachRentService machRentService;

    @Test
    void register() {

        MachRentDTO machRentDTO = MachRentDTO.builder()
                .cst_code("CST0001")
                .rent_start("2023. 02. 03")
                .rent_end("2023. 02. 10")
                .rent_bill_date("2023. 03. 10")
                .m_code("다이소1")
                .rent_supp_value(10000L)
                .rent_tax(1000L)
                .rent_collect_date("2023. 03. 10")
                .rent_collect_value(11000L)
                .rent_misu(0L)
                .rent_finished(true)
                .rent_etc("테스트")
                .build();

        int register = machRentService.register(machRentDTO);

        log.info(String.valueOf(register));
    }

    @Test
    void selectAllForList() {

        List<MachRentListDTO> machRentListDTOS = machRentService.selectAllForList();

        machRentListDTOS.forEach(machRentListDTO -> log.info(String.valueOf(machRentListDTO)));
    }

    @Test
    void selectAllFindByKind() {

        List<MachRentListDTO> machRentListDTOS = machRentService.selectAllFindByKind("포장");

        machRentListDTOS.forEach(machRentListDTO -> log.info(String.valueOf(machRentListDTO)));
    }
}