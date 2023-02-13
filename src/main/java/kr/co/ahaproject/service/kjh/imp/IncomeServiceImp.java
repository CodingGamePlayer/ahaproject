package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import kr.co.ahaproject.mapper.kjh.IncomeMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
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
    public List<IncomeOutcomeDTO> findByClcode(String cl_code) {
        List<IncomeOutcome> ios = incomeMapper.findByClcode(cl_code);

        ios.forEach(io -> io.toString());
        List<IncomeOutcomeDTO> list = ios.stream()
                .map(io -> modelMapper.map(io, IncomeOutcomeDTO.class))
                .collect(Collectors.toList());
        list.forEach(ioDTO -> ioDTO.toString());
        return list;
    }

    @Override
    public IncomeOutcomeDTO selectOne(long io_id) {
        IncomeOutcome io = incomeMapper.selectOne(io_id);
        IncomeOutcomeDTO ioDTO = modelMapper.map(io, IncomeOutcomeDTO.class);
        return ioDTO;
    }


    @Override
    public int insert(IncomeOutcomeDTO ioDTO) {

        String after = new AhaCommonMethod().changeDate(ioDTO.getIo_date());
        ioDTO.setIo_date(after);

        long total = 0;
        ioDTO.setIn_total_value(total);
        ioDTO.setIn_collect_remain(total);

        IncomeOutcome io = modelMapper.map(ioDTO, IncomeOutcome.class);

        int result = incomeMapper.insert(io);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(IncomeOutcomeDTO ioDTO) {
        String after = new AhaCommonMethod().changeDate(ioDTO.getIo_date());
        ioDTO.setIo_date(after);

        IncomeOutcome io = modelMapper.map(ioDTO, IncomeOutcome.class);

        int result = incomeMapper.update(io);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(IncomeOutcomeDTO ioDTO) {
        IncomeOutcome io = modelMapper.map(ioDTO, IncomeOutcome.class);
        int result = incomeMapper.delete(io);
        if (result < 0) {
            return 0;
        }
        return 1;
    }
}
