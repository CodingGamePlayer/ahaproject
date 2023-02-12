package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import kr.co.ahaproject.service.kjs.MachRentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalendarServiceImp implements CalendarService {

    private final MachRentService machRentService;

    @Override
    public List<CalendarDTO> selectAll() {

        List<MachRentDTO> machRentDTOS = machRentService.selectAll();

        List<CalendarDTO> calendarDTOS = machRentDTOS.stream()
                .map(machRentDTO -> new CalendarDTO().convert(machRentDTO))
                .collect(Collectors.toList());

        return calendarDTOS;
    }

    @Override
    public List<CountMachRentDTO> countRent() {
        List<CalendarDTO> calendarDTOS = selectAll();

        List<String> yearArr = new ArrayList<>();
        List<CountMachRentDTO> resultDTOS = new ArrayList<>();

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
                resultDTOS.add(machRentDTOList.get(i));
            }
        }

//        machRentDTOList.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
//        resultDTOS.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
//        log.info((String) map.get("2023"));


        return resultDTOS;
    }
}
