package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.BlackListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

public interface BlackService {

    public PageResponseDTO<BlackListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

    public int delete(BlackListDTO blackListDTO);

    public int insert(BlackListDTO blackListDTO);

    public int update(BlackListDTO blackListDTO);
}
