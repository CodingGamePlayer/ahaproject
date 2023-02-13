package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;

import java.util.List;

public interface SummaryService {
    List<IncomeOutcomeDTO> selectAll();
}
