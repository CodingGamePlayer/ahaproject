package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;

import java.util.List;

public interface OutcomeService {
    List<IncomeOutcomeDTO> selectAll();

    IncomeOutcomeDTO selectOne(long io_id);

    int insert(IncomeOutcomeDTO ioDTO);

    int update(IncomeOutcomeDTO ioDTO);

    int delete(IncomeOutcomeDTO ioDTO);
}
