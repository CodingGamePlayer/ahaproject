package kr.co.ahaproject.service.moo;

import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.dto.LaborCostListDTO;
import kr.co.ahaproject.entity.LaborCost;

import java.util.List;

public interface LaborCostService {
    // 인건비 등록하기
    int register(LaborCostDTO laborCostDTO);

    // 인건비 전체보기
    List<LaborCostDTO> selectAll();

    // 인건비 전체보기(코드->이름)
    List<LaborCostListDTO> selectAllName();

    // 인건비 수정하기
    int update(LaborCostDTO laborCostDTO);

    // 인건비 삭제하기
    int delete(LaborCostDTO laborCostDTO);

    // 인건비 상세보기
    LaborCostDTO findById(LaborCostDTO laborCostDTO);
}
