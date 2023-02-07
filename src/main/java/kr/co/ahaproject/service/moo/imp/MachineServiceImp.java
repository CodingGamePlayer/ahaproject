package kr.co.ahaproject.service.moo.imp;

import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.entity.Machine;
import kr.co.ahaproject.mapper.moo.MachineMapper;
import kr.co.ahaproject.service.moo.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MachineServiceImp implements MachineService {
    @Autowired
    private MachineMapper machineMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(MachineDTO machineDTO) {
        int result = machineMapper.register(modelMapper.map(machineDTO, Machine.class));

        if(!(result > 0)){
            return 0;
        }
        return 1;
    }

    @Override
    public List<MachineDTO> selectAll() {

        List<Machine> machineList = machineMapper.selectAll();

        return machineList.stream()
                .map(machine -> modelMapper.map(machine, MachineDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int update(MachineDTO machineDTO) {
        return 0;
    }
}
