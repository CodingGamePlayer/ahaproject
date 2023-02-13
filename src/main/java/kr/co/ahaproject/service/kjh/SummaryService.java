package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.OutcomeDTO;

import java.util.List;

public interface SummaryService {
    List<OutcomeDTO> selectAll();
}
