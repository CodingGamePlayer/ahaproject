package kr.co.ahaproject.service.kjh.Imp;

import kr.co.ahaproject.ChartDTOTest;
import kr.co.ahaproject.dto.CountMachRentDTO;
import kr.co.ahaproject.dto.OutcomeDTO;
import kr.co.ahaproject.entity.Outcome;
import kr.co.ahaproject.mapper.kjh.OutcomeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
public class ChartTest {
    @Autowired
    OutcomeMapper outcomeMapper;
    ModelMapper modelMapper = new ModelMapper();

    @Test
    void chart() {
        String year = "2024";
        List<Outcome> outs = outcomeMapper.selectAll();
//
//        outs.forEach(out -> out.toString());
//        List<OutcomeDTO> outDTOs = outs.stream()
//                .map(out -> modelMapper.map(out, OutcomeDTO.class))
//                .collect(Collectors.toList());
//        outDTOs.forEach(outDTO -> outDTO.toString());

        ChartDTOTest chartDTO = new ChartDTOTest("outcome",year );

        for (Outcome outDTO : outs) {
            System.out.println(outDTO.getOut_date().substring(0,4));
            if(outDTO.getOut_date().substring(0, 4).equals(year)){
            chartDTO.chart(outDTO.getOut_date().substring(5, 7), outDTO.getOut_supp_value());
        }}
        System.out.println(chartDTO);
    }
}
