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

        List<CalendarDTO> calendarDTOS = calendarService.selectAll();

        calendarDTOS.forEach(calendarDTO -> calendarDTO.toString());

    }

    @Test
    void countRent() {

        List<CalendarDTO> calendarDTOS = calendarService.selectAll();

        List<String> yearArr = new ArrayList<>();
        List<CountMachRentDTO> rentDTOS = new ArrayList<>();

        for (int i = 0; i < calendarDTOS.size(); i++) {
            String year = calendarDTOS.get(i).getStart().substring(0, 4);


            if (!yearArr.contains(year)) {
                yearArr.add(year);
            }
        }

//        log.info(yearArr.toString());

        List<CountMachRentDTO> machRentDTOList = yearArr.stream()
                .map(s -> new CountMachRentDTO(s))
                .collect(Collectors.toList());

//        log.info(machRentDTOList.toString());

        for (int i = 0; i < calendarDTOS.size(); i++) {
            String year = calendarDTOS.get(i).getStart().substring(0, 4);
            String month = calendarDTOS.get(i).getStart().substring(5, 7);

            for (int j = 0; j < machRentDTOList.size(); j++) {
                if (machRentDTOList.get(j).getYear().equals(year)) {
                    machRentDTOList.get(j).increaseCount(month);
                }
            }
        }

        for (int i = 0; i < machRentDTOList.size(); i++) {
            if (machRentDTOList.get(i).getYear().equals("2023")){
                rentDTOS.add(machRentDTOList.get(i));
            }
        }

//        machRentDTOList.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
        rentDTOS.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
//        log.info((String) map.get("2023"));


    }
}