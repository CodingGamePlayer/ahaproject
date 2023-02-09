package kr.co.ahaproject.service.moo;

import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.entity.LaborCost;

import java.util.List;

public interface LaborCostService {
    int register(LaborCostDTO laborCostDTO);

    List<LaborCostDTO> selectAll();

    int update(LaborCostDTO laborCostDTO);
}
