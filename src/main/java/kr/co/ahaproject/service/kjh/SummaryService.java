package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.SummaryDTO;

import java.util.List;

public interface SummaryService {
    List<SummaryDTO> selectAll();
}
