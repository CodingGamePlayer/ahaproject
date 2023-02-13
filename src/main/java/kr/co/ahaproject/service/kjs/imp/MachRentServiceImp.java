package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.entity.MachRent;
import kr.co.ahaproject.mapper.kjs.MachrentMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.kjs.MachRentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MachRentServiceImp implements MachRentService {
    @Autowired
    private MachrentMapper machrentMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(MachRentDTO machRentDTO) {

        String rent_start = new AhaCommonMethod().changeDate(machRentDTO.getRent_start());
        String rent_end = new AhaCommonMethod().changeDate(machRentDTO.getRent_end());

        if (!machRentDTO.getRent_collect_date().equals("")) {
            String rent_collect_date = new AhaCommonMethod().changeDate(machRentDTO.getRent_collect_date());
            machRentDTO.setRent_collect_date(rent_collect_date);
        }
        String rent_bill_date = new AhaCommonMethod().changeDate(machRentDTO.getRent_bill_date());

        machRentDTO.setRent_start(rent_start);
        machRentDTO.setRent_end(rent_end);
        machRentDTO.setRent_bill_date(rent_bill_date);

        int result = machrentMapper.register(modelMapper.map(machRentDTO, MachRent.class));

        if (!(result > 0)) {
            return 0;
        }
        return 1;
    }

    @Override
    public List<MachRentDTO> selectAll() {
        List<MachRent> machRentList = machrentMapper.selectAll();

        return machRentList.stream()
                .map(machRent -> modelMapper.map(machRent, MachRentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int update(MachRentDTO machRentDTO) {
        String rent_start = new AhaCommonMethod().changeDate(machRentDTO.getRent_start());
        String rent_end = new AhaCommonMethod().changeDate(machRentDTO.getRent_end());
        String rent_bill_date = new AhaCommonMethod().changeDate(machRentDTO.getRent_bill_date());

        if (!machRentDTO.getRent_collect_date().equals("")) {
            String rent_collect_date = new AhaCommonMethod().changeDate(machRentDTO.getRent_collect_date());
            machRentDTO.setRent_collect_date(rent_collect_date);
        }

        machRentDTO.setRent_start(rent_start);
        machRentDTO.setRent_end(rent_end);
        machRentDTO.setRent_bill_date(rent_bill_date);

        MachRent machRent = modelMapper.map(machRentDTO, MachRent.class);
        int update = machrentMapper.update(machRent);

        if (!(update > 0)) {
            return 0;
        }

        return update;
    }

    @Override
    public MachRentDTO findById(MachRentDTO machRentDTO) {
        MachRent machRent = machrentMapper.findById(modelMapper.map(machRentDTO, MachRent.class));
        return modelMapper.map(machRent, MachRentDTO.class);
    }

    @Override
    public int delete(MachRentDTO machRentDTO) {
        int result = machrentMapper.delete(modelMapper.map(machRentDTO, MachRent.class));

        if (!(result > 0)) {
            return 0;
        }

        return result;

    }

    @Override
    public List<MachRentListDTO> selectAllForList() {

        List<MachRentListDTO> machRentListDTOS = machrentMapper.selectAllForList();

        return machRentListDTOS;
    }

    @Override
    public List<MachRentListDTO> selectAllFindByKind(String kind) {

        List<MachRentListDTO> machRentListDTOS = machrentMapper.selectAllFindByKind(kind);

        return machRentListDTOS;
    }

    @Override
    public List<MachRentListDTO> selectAllWithoutKind() {

        List<MachRentListDTO> machRentListDTOS = machrentMapper.selectAllWithoutKind();

        return machRentListDTOS;
    }
}