package kr.co.ahaproject.service.kjh;

import io.swagger.v3.oas.models.security.SecurityScheme;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;

import java.util.List;

public interface IncomeService {
    List<IncomeOutcomeDTO> selectAll();

    IncomeOutcomeDTO selectOne(long io_id);

    int insert(IncomeOutcomeDTO ioDTO);

    int update(IncomeOutcomeDTO ioDTO);

    int delete(IncomeOutcomeDTO ioDTO);
}
