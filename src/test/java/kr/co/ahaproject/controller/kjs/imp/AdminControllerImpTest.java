package kr.co.ahaproject.controller.kjs.imp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminControllerImpTest {

    @Test
    void misu() {
        String date = "02";
        int i = Integer.parseInt(date);

        log.info("{} + 1 = {}", i, i+1);

    }
}