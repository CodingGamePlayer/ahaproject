package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.BlackListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.mapper.kjs.BlackListMapper;
import kr.co.ahaproject.service.kjs.BlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListServiceImp implements BlackService {

    private final BlackListMapper blackListMapper;

    @Override
    public PageResponseDTO<BlackListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {
        return null;
    }

    @Override
    public int delete(BlackListDTO blackListDTO) {
        return 0;
    }

    @Override
    public int insert(BlackListDTO blackListDTO) {
        return 0;
    }

    @Override
    public int update(BlackListDTO blackListDTO) {
        return 0;
    }
}
