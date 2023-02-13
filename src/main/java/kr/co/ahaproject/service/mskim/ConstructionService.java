package kr.co.ahaproject.service.mskim;

import kr.co.ahaproject.dto.ConstructionDTO;

import java.util.List;

public interface ConstructionService {

    List<ConstructionDTO> selectAll();
    
    ConstructionDTO findByCst(ConstructionDTO cstDTO);
    
    int regist(ConstructionDTO cstDTO);
    
    int update(ConstructionDTO cstDTO);
    
    int delete(ConstructionDTO cstDTO);
<<<<<<< HEAD
    
    int codeCount();
=======
>>>>>>> branch 'master' of https://github.com/CodingGamePlayer/ahaproject.git
}
