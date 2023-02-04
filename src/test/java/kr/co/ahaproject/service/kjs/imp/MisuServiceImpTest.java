package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.MisuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MisuServiceImpTest {

    @Autowired
    private MisuService misuService;

    @Test
    void register() {

        MisuDTO misuDTO = MisuDTO.builder()
                .misu_div("개인")
                .cp_name("회사")
                .cst_code("p00001")
                .misu_manager("김머용")
                .misu_value(1000000L)
                .misu_name("공사비용")
                .misu_total_value(1000000L)
                .misu_collect_date("2023-02-02")
                .misu_collect_value(0L)
                .misu_finished(false)
                .misu_etc("없음")
                .build();

        int result = misuService.register(misuDTO);

        log.info(String.valueOf(result));
    }
}