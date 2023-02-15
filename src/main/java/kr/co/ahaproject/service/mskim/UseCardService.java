package kr.co.ahaproject.service.mskim;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;

import java.util.List;

public interface UseCardService {
	
	List<UseCardJoinDTO> selectAll();
	
	List<UseCardJoinDTO> selectOne(int card_id);
	
    int regist(UseCardDTO ucDTO);
    
    int update(UseCardDTO ucDTO);
    
    int delete(UseCardDTO ucDTO);
    
    UseCardJoinDTO getFindUcId(int uc_id);

    PageResponseDTO<UseCardJoinDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);


}
