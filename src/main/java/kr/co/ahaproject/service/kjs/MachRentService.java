package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;

import java.util.List;

public interface MachRentService {
    int register(MachRentDTO machRentDTO);

    List<MachRentDTO> selectAll();

    int update(MachRentDTO machRentDTO);

    MachRentDTO findById(MachRentDTO machRentDTO);

    int delete(MachRentDTO machRentDTO);

    List<MachRentListDTO> selectAllForList();
}
