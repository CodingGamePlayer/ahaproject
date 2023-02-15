package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import kr.co.ahaproject.service.moo.MachRentService;
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
    public List<CalendarDTO> selectAll(String kind) {

        List<MachRentListDTO> machRentListDTOS = machRentService.selectAllFindByKind(kind);

        List<CalendarDTO> calendarDTOS = machRentListDTOS.stream()
                .map(machRentListDTO -> new CalendarDTO().convert(machRentListDTO))
                .collect(Collectors.toList());

        return calendarDTOS;
    }

    @Override
    public List<CalendarDTO> selectAllWithoutKind() {

        List<MachRentListDTO> machRentListDTOS = machRentService.selectAllWithoutKind();

        List<CalendarDTO> calendarDTOS = machRentListDTOS.stream()
                .map(machRentListDTO -> new CalendarDTO().convert(machRentListDTO))
                .collect(Collectors.toList());
        return calendarDTOS;
    }

    @Override
    public CountMachRentDTO countRent(String requestYear, String kind) {
        List<CalendarDTO> calendarDTOS = selectAll(kind);

        List<String> yearArr = new ArrayList<>();

        for (int i = 0; i < calendarDTOS.size(); i++) {
            String year = calendarDTOS.get(i).getStart().substring(0, 4);

            if (!yearArr.contains(year)) {
                yearArr.add(year);
            }
        }

//        log.info(yearArr.toString());

        List<CountMachRentDTO> countMachRentDTOS = yearArr.stream()
                .map(s -> new CountMachRentDTO(s))
                .collect(Collectors.toList());

//        log.info(machRentDTOList.toString());

        for (int i = 0; i < calendarDTOS.size(); i++) {
            String year = calendarDTOS.get(i).getStart().substring(0, 4);
            String month = calendarDTOS.get(i).getStart().substring(5, 7);

            for (int j = 0; j < countMachRentDTOS.size(); j++) {
                if (countMachRentDTOS.get(j).getYear().equals(year)) {
                    countMachRentDTOS.get(j).increaseCount(month);
                }
            }
        }

        for (int i = 0; i < countMachRentDTOS.size(); i++) {
            if (countMachRentDTOS.get(i).getYear().equals(requestYear)){
                return countMachRentDTOS.get(i);
            }
        }

//        machRentDTOList.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
//        resultDTOS.forEach(countMachRentDTO -> log.info(String.valueOf(countMachRentDTO)));
//        log.info((String) map.get("2023"));

        return null;
    }

}
