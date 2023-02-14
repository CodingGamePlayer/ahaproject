package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> selectAll();
    
    CompanyDTO findById(CompanyDTO companyDTO);
    
    int register(CompanyDTO companyDTO);

    int update(CompanyDTO companyDTO);
    
    int delete(CompanyDTO companyDTO);

    PageResponseDTO<CompanyDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
//  페이징 연습 중 ..
    
    int count();
    
    List<CompanyDTO> pageList(int displayPost, int postNum);
    
    
}
