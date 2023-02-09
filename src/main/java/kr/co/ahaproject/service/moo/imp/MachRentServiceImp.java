package kr.co.ahaproject.service.moo.imp;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.service.moo.MachRentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MachRentServiceImp implements MachRentService {
    @Override
    public int register(MachRentDTO machRentDTO) {
        return 0;
    }

    @Override
    public List<MachRentDTO> selectAll() {
        return null;
    }

    @Override
    public int update(MachRentDTO machRentDTO) {
        return 0;
    }

    @Override
    public MachRentDTO findById(MachRentDTO machRentDTO) {
        return null;
    }

    @Override
    public int delete(MachRentDTO machRentDTO) {
        return 0;
    }
}
