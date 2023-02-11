package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import kr.co.ahaproject.service.moo.MachRentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String, Integer> countRent() {

        Map<String, Integer> map = new HashMap<>();
        int[] jangbi;
        int[] pojang;



        return null;
    }
}
