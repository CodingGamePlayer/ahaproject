package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CalendarDTO;

import java.util.List;

public interface CalendarService {

    List<CalendarDTO> selectAll();
}
