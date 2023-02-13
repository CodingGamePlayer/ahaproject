package kr.co.ahaproject.service.moo.imp;

import groovy.util.logging.Slf4j;
import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.entity.LaborCost;
import kr.co.ahaproject.entity.Machine;
import kr.co.ahaproject.mapper.moo.LaborCostMapper;
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
    @Override
    public int register(LaborCostDTO laborCostDTO) {
        return 0;
    }

    @Override
    public List<LaborCostDTO> selectAll() {
//        List<LaborCost> laborCostList = laborCostMapper.selectAll();
//
//        return laborCostList.stream()
//                .map(laborCost -> modelMapper.map(laborCost, LaborCostDTO.class))
//                .collect(Collectors.toList());

    return null;}

    @Override
    public int update(LaborCostDTO laborCostDTO) {
        return 0;
    }
}
