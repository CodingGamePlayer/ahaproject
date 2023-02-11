package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CalendarServiceImpTest {

    @Autowired
    private CalendarService calendarService;

    @Test
    void selectAll() {

        List<CalendarDTO> calendarDTOS = calendarService.selectAll();

        calendarDTOS.forEach(calendarDTO -> calendarDTO.toString());

    }
}