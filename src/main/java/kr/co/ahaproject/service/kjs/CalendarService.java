package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CalendarDTO;

import java.util.List;
import java.util.Map;

public interface CalendarService {

    List<CalendarDTO> selectAll();

    Map<String, Integer> countRent();
}
