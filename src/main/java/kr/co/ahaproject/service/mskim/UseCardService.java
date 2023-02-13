package kr.co.ahaproject.service.mskim;

import java.util.List;

import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;

public interface UseCardService {
	
	List<UseCardJoinDTO> selectAll();
	
	List<UseCardJoinDTO> selectOne(int card_id);
	
    int regist(UseCardDTO ucDTO);
    
    int update(UseCardDTO ucDTO);
    
    int delete(UseCardDTO ucDTO);
    
    UseCardJoinDTO getFindUcId(int uc_id);

}
