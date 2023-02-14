package kr.co.ahaproject.service.moo;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

import java.util.List;

public interface MachRentService {
    int register(MachRentDTO machRentDTO);

    List<MachRentDTO> selectAll();

    int update(MachRentDTO machRentDTO);

    MachRentDTO findById(MachRentDTO machRentDTO);

    int delete(MachRentDTO machRentDTO);

    List<MachRentListDTO> selectAllForList();

    List<MachRentListDTO> selectAllFindByKind(String kind);
    List<MachRentListDTO> selectAllWithoutKind();

    PageResponseDTO<MachRentListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
}
