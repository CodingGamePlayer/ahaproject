package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.dto.CountMachRentDTO;

import java.util.List;

public interface CalendarService {

    List<CalendarDTO> selectAll(String kind);
    List<CalendarDTO> selectAllWithoutKind();

    CountMachRentDTO countRent(String requestYear,String kind);
}
