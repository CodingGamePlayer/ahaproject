package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.IncomeDTO;
import kr.co.ahaproject.entity.Income;
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
    public List<IncomeDTO> selectAll() {
        List<Income> ins = incomeMapper.selectAll();

        ins.forEach(in -> in.toString());
        List<IncomeDTO> list = ins.stream()
                .map(in -> modelMapper.map(in, IncomeDTO.class))
                .collect(Collectors.toList());
        list.forEach(inDTO -> inDTO.toString());
        return list;
    }


    @Override
    public IncomeDTO selectOne(long in_id) {
        Income in = incomeMapper.selectOne(in_id);
        IncomeDTO inDTO = modelMapper.map(in, IncomeDTO.class);
        return inDTO;
    }


    @Override
    public int insert(IncomeDTO inDTO) {

        String after = new AhaCommonMethod().changeDate(inDTO.getIn_date());
        inDTO.setIn_date(after);

        long total = 0;
        inDTO.setIn_total_value(total);
        inDTO.setIn_collect_remain(total);

        Income in = modelMapper.map(inDTO, Income.class);

        int result = incomeMapper.insert(in);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update(IncomeDTO inDTO) {
        String after = new AhaCommonMethod().changeDate(inDTO.getIn_date());
        inDTO.setIn_date(after);

        Income in = modelMapper.map(inDTO, Income.class);

        int result = incomeMapper.update(in);
        if (result < 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(IncomeDTO inDTO) {
        Income in = modelMapper.map(inDTO, Income.class);
        int result = incomeMapper.delete(in);
        if (result < 0) {
            return 0;
        }
        return 1;
    }
}
