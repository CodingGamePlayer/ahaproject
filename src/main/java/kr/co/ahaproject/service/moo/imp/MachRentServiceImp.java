package kr.co.ahaproject.service.moo.imp;

import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.MachRent;
import kr.co.ahaproject.entity.Machine;
import kr.co.ahaproject.mapper.moo.MachineMapper;
import kr.co.ahaproject.mapper.moo.MachrentMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.moo.MachRentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MachRentServiceImp implements MachRentService {

    private final MachrentMapper machrentMapper;

    private final MachineMapper machineMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(MachRentDTO machRentDTO) {
        Machine target = machineMapper.findByCode(machRentDTO.getM_code());

        MachRentDTO machRentDTO1 = changDateFormat(machRentDTO);

        MachRent machRent = modelMapper.map(machRentDTO1, MachRent.class);
        int result = machrentMapper.register(machRent);

        changeMachCondition(machRent, target);

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

        Machine target = machineMapper.findByCode(machRentDTO.getM_code());

        MachRentDTO machRentDTO1 = changDateFormat(machRentDTO);

        MachRent machRent = modelMapper.map(machRentDTO1, MachRent.class);
        int update = machrentMapper.update(machRent);

        changeMachCondition(machRent, target);

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
        Machine target = machineMapper.findByCode(machRentDTO.getM_code());

        MachRent machRent = modelMapper.map(machRentDTO, MachRent.class);

        int result = machrentMapper.delete(machRent);

        Boolean rent_finished = machRent.getRent_finished();

        if (rent_finished == false) {
            target.setM_use(false);
            machineMapper.update(target);
        }

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

    @Override
    public PageResponseDTO<MachRentListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

        List<MachRentListDTO> machRentList = machrentMapper.selectAllForPaging(pageRequestDTO);

        int count = machrentMapper.getCount(pageRequestDTO);

        PageResponseDTO<MachRentListDTO> pageResponseDTO = PageResponseDTO.<MachRentListDTO>withAll()
                .dtoList(machRentList)
                .total(count)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    private MachRentDTO changDateFormat(MachRentDTO machRentDTO){
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

        return machRentDTO;
    }

    private void changeMachCondition (MachRent machRent, Machine target){
        Boolean rent_finished = machRent.getRent_finished();
        if (rent_finished == true) {
            target.setM_use(false);
            machineMapper.update(target);
        } else {
            target.setM_use(true);
            machineMapper.update(target);
        }
    }
}
