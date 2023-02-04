package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.service.kjs.ConstructionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ConstructionServiceImpTest {

    @Autowired
    private ConstructionService constructionService;

    @Test
    void selectAll() {

        List<ConstructionDTO> constructionDTOS = constructionService.selectAll();

        constructionDTOS.forEach(constructionDTO -> log.info(String.valueOf(constructionDTO)));
    }
}