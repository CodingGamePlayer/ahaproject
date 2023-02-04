package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.mapper.kjs.MisuMapper;
import kr.co.ahaproject.service.kjs.MisuService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MisuServiceImp implements MisuService {

    @Autowired
    private MisuMapper misuMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(MisuDTO misuDTO) {

        int result = misuMapper.register(modelMapper.map(misuDTO, Misu.class));

        if(! (result > 0)){
            return 0;
        }

        return 1;
    }
}
