package kr.co.ahaproject.service.moo;

import kr.co.ahaproject.dto.MachineDTO;

import java.util.List;

public interface MachineService {

    int register(MachineDTO machineDTO);

    List<MachineDTO> selectAll();

    int update(MachineDTO machineDTO);


   Integer getm_code();

}
