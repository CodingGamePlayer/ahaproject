package kr.co.ahaproject.service.mskim;

import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

import java.util.List;

public interface ConstructionService {

    List<ConstructionDTO> selectAll();
    
    ConstructionDTO findByCst(ConstructionDTO cstDTO);
    
    int regist(ConstructionDTO cstDTO);
    
    int update(ConstructionDTO cstDTO);
    
    int delete(ConstructionDTO cstDTO);
    
    int codeCount();

    PageResponseDTO<ConstructionDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
}
