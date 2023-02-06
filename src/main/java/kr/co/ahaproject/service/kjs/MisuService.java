package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.MisuDTO;

import java.util.List;

public interface MisuService {

    int register(MisuDTO misuDTO);

    List<MisuDTO> selectAll();

    MisuDTO findById(MisuDTO misuDTO);

    int update(MisuDTO misuDTO);
}
