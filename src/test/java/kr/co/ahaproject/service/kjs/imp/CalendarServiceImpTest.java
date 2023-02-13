package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class CalendarServiceImpTest {

    @Autowired
    private CalendarService calendarService;

    @Test
    void selectAll() {

        List<CalendarDTO> calendarDTOS = calendarService.selectAll("장비");

        calendarDTOS.forEach(calendarDTO -> calendarDTO.toString());

    }

    @Test
    void countRent() {

        String kind = "장비";

        CountMachRentDTO rentDTOS = calendarService.countRent("2022",kind);

       log.info(String.valueOf(rentDTOS));


    }


}