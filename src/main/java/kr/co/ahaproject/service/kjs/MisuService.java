package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

import java.util.List;

public interface MisuService {

    int register(MisuDTO misuDTO);

    List<MisuDTO> selectAll();

    MisuDTO findById(MisuDTO misuDTO);

    int update(MisuDTO misuDTO);

    int delete(MisuDTO misuDTO);

    PageResponseDTO<AccountDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

}
