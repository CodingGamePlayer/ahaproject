package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.SummaryDTO;
import kr.co.ahaproject.entity.Summary;
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
    public List<SummaryDTO> selectAll() {
        List<Summary> summaries = summaryMapper.selectAll();
        summaries.forEach(io -> io.toString());
        List<SummaryDTO> list = summaries.stream()
                .map(io -> modelMapper.map(io, SummaryDTO.class))
                .collect(Collectors.toList());
        list.forEach(SummayDTO -> SummayDTO.toString());
        return list;
    }
}
