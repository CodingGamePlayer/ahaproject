package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class CalendarServiceImpTest {

    @Autowired
    private CalendarService calendarService;

    @Test
    void selectAll() {

        List<CalendarDTO> calendarDTOS = calendarService.selectAll();

        calendarDTOS.forEach(calendarDTO -> calendarDTO.toString());

    }
    @Test
    void countRent() {

        Map<String, List> map = new HashMap<>();

        for(int i=1; i <= 12; i++){

            String month = String.format("%02d", i);
            log.info(month);

        }
    }
}