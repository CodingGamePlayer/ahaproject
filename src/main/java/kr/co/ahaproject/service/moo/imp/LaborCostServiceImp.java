package kr.co.ahaproject.service.moo.imp;

import groovy.util.logging.Slf4j;
import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.dto.LaborCostListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.LaborCost;
import kr.co.ahaproject.mapper.moo.LaborCostMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.moo.LaborCostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LaborCostServiceImp implements LaborCostService {

    @Autowired
    private LaborCostMapper laborCostMapper;

    private ModelMapper modelMapper = new ModelMapper();

    // 인건비 등록하기
    @Override
    public int register(LaborCostDTO laborCostDTO) {
        String lc_date = new AhaCommonMethod().changeDate(laborCostDTO.getLc_date());

        laborCostDTO.setLc_date(lc_date);

        int result = laborCostMapper.register(modelMapper.map(laborCostDTO, LaborCost.class));

        if (!(result > 0)) {
            return 0;
        }
        return 1;
    }

    // 인건비 전체보기
    @Override
    public List<LaborCostDTO> selectAll() {
        List<LaborCost> laborCostList = laborCostMapper.selectAll();

        return laborCostList.stream()
                .map(laborCost -> modelMapper.map(laborCost, LaborCostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LaborCostListDTO> selectAllName() {
        List<LaborCostListDTO> laborCostList = laborCostMapper.selectAllName();

        return laborCostList.stream()
                .map(laborCost -> modelMapper.map(laborCost, LaborCostListDTO.class))
                .collect(Collectors.toList());
    }

    // 인건비 수정하기
    @Override
    public int update(LaborCostDTO laborCostDTO) {
        String lc_date = new AhaCommonMethod().changeDate(laborCostDTO.getLc_date());

        laborCostDTO.setLc_date(lc_date);

        LaborCost laborCost = modelMapper.map(laborCostDTO, LaborCost.class);
        int update = laborCostMapper.update(laborCost);

        if (!(update > 0)) {
            return 0;
        }
        return update;
    }

    // 인건비 삭제하기
    @Override
    public int delete(LaborCostDTO laborCostDTO) {
        int result = laborCostMapper.delete(modelMapper.map(laborCostDTO, LaborCost.class));

        if (!(result > 0)) {
            return 0;
        }

        return result;
    }

    @Override
    public LaborCostDTO findById(LaborCostDTO laborCostDTO) {
        LaborCost laborCost = laborCostMapper.findById(modelMapper.map(laborCostDTO, LaborCost.class));
        return modelMapper.map(laborCost, LaborCostDTO.class);
    }

    @Override
    public PageResponseDTO<LaborCostListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

        List<LaborCostListDTO> laborCosts = laborCostMapper.selectAllForPaging(pageRequestDTO);

        int total = laborCostMapper.getCount(pageRequestDTO);

        PageResponseDTO<LaborCostListDTO> pageResponseDTO = PageResponseDTO.<LaborCostListDTO>withAll()
                .dtoList(laborCosts)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }
}

