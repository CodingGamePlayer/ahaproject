package kr.co.ahaproject.service.kjh;

import kr.co.ahaproject.dto.IncomeDTO;

import java.util.List;

public interface IncomeService {
    List<IncomeDTO> selectAll();

    IncomeDTO selectOne(long in_id);

    int insert(IncomeDTO inDTO);

    int update(IncomeDTO inDTO);

    int delete(IncomeDTO inDTO);


}
