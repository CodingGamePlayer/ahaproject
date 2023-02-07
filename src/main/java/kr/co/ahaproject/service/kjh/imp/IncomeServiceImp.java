package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import kr.co.ahaproject.mapper.kjh.IncomeMapper;
import kr.co.ahaproject.service.kjh.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImp implements IncomeService {
    @Autowired
    IncomeMapper incomeMapper;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<IncomeOutcomeDTO> selectAll() {
        List<IncomeOutcome> ios = incomeMapper.selectAll();
        ios.forEach(io -> io.toString());
        List<IncomeOutcomeDTO> list = ios.stream()
                .map(io -> modelMapper.map(io, IncomeOutcomeDTO.class))
                .collect(Collectors.toList());
        list.forEach(ioDTO -> ioDTO.toString());
        return list;
    }

    @Override
    public IncomeOutcomeDTO selectOne(int id) {
        IncomeOutcomeDTO ioDTO = modelMapper.map(incomeMapper.selectOne(id), IncomeOutcomeDTO.class);
        return ioDTO;
    }

    @Override
    public int insert(IncomeOutcomeDTO ioDTO) {
        IncomeOutcome io = modelMapper.map(ioDTO, IncomeOutcome.class);

        int result = incomeMapper.insert(io);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(IncomeOutcomeDTO ioDTO) {
        IncomeOutcome io = modelMapper.map(ioDTO, IncomeOutcome.class);

        int result = incomeMapper.update(io);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int id) {

        int result = incomeMapper.delete(id);
        if (result < 0) {
            return 0;
        }
        return 1;
    }
}
