package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.mapper.kjs.MisuMapper;
import kr.co.ahaproject.service.kjs.MisuService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MisuServiceImp implements MisuService {

    @Autowired
    private MisuMapper misuMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(MisuDTO misuDTO) {

        int result = misuMapper.register(modelMapper.map(misuDTO, Misu.class));

        if (!(result > 0)) {
            return 0;
        }

        return 1;
    }

    @Override
    public List<MisuDTO> selectAll() {

        List<Misu> misuList = misuMapper.selectAll();

        return misuList.stream()
                .map(misu -> modelMapper.map(misu, MisuDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MisuDTO findById(MisuDTO misuDTO) {

        Misu misu = misuMapper.findById(modelMapper.map(misuDTO, Misu.class));
        return modelMapper.map(misu, MisuDTO.class);
    }

    @Override
    public int update(MisuDTO misuDTO) {
        Misu misu = modelMapper.map(misuDTO, Misu.class);
        int update = misuMapper.update(misu);

        if(!(update>0)){
            return 0;
        }

        return update;
    }
}
