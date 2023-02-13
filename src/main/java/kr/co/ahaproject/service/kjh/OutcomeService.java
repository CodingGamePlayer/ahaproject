package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.OutcomeDTO;

import java.util.List;

public interface OutcomeService {
    List<OutcomeDTO> selectAll();

    OutcomeDTO selectOne(long out_id);

    int insert(OutcomeDTO outDTO);

    int update(OutcomeDTO outDTO);

    int delete(OutcomeDTO outDTO);
}
