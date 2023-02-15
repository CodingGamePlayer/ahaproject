package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.OutcomeDTO;
import kr.co.ahaproject.entity.Outcome;
import kr.co.ahaproject.mapper.kjh.OutcomeMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.kjh.OutcomeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class OutcomeServiceImp implements OutcomeService {
    @Autowired
    OutcomeMapper outcomeMapper;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<OutcomeDTO> selectAll() {
        List<Outcome> outs = outcomeMapper.selectAll();
        outs.forEach(out -> out.toString());
        List<OutcomeDTO> list = outs.stream()
                .map(out -> modelMapper.map(out, OutcomeDTO.class))
                .collect(Collectors.toList());
        list.forEach(outDTO -> outDTO.toString());
        return list;
    }
// 하
    @Override
    public OutcomeDTO selectOne(long out_id) {
        Outcome out = outcomeMapper.selectOne(out_id);
        OutcomeDTO outDTO = modelMapper.map(out, OutcomeDTO.class);
        log.info(outDTO.getOut_date());
        return outDTO;
    }


    @Override
    public int insert(OutcomeDTO outDTO) {

        String after = new AhaCommonMethod().changeDate(outDTO.getOut_date());
        outDTO.setOut_date(after);

        long total = 0;
        outDTO.setOut_total_value(total);
        outDTO.setOut_collect_remain(total);

        Outcome out = modelMapper.map(outDTO, Outcome.class);

        int result = outcomeMapper.insert(out);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(OutcomeDTO outDTO) {
        String after = new AhaCommonMethod().changeDate(outDTO.getOut_date());
        outDTO.setOut_date(after);

        Outcome out = modelMapper.map(outDTO, Outcome.class);

        int result = outcomeMapper.update(out);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(OutcomeDTO outDTO) {
        Outcome out = modelMapper.map(outDTO, Outcome.class);
        int result = outcomeMapper.delete(out);
        if (result < 0) {
            return 0;
        }
        return 1;
    }
}
