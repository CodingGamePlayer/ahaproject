package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import kr.co.ahaproject.mapper.kjh.IncomeMapper;
import kr.co.ahaproject.mapper.kjh.SummaryMapper;
import kr.co.ahaproject.service.kjh.SummaryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SummaryServiceImp implements SummaryService {
    @Autowired
    SummaryMapper summaryMapper;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<IncomeOutcomeDTO> selectAll() {
        List<IncomeOutcome> ios = summaryMapper.selectAll();
        ios.forEach(io -> io.toString());
        List<IncomeOutcomeDTO> list = ios.stream()
                .map(io -> modelMapper.map(io, IncomeOutcomeDTO.class))
                .collect(Collectors.toList());
        list.forEach(ioDTO -> ioDTO.toString());
        return list;
    }
}
