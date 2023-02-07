package kr.co.ahaproject.service.kjh.imp;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import kr.co.ahaproject.mapper.kjh.IncomeMapper;
import kr.co.ahaproject.service.kjh.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImcomeServiceImp implements IncomeService {
    @Autowired
    IncomeMapper incomeMapper;
    @Override
    public List<IncomeOutcomeDTO> selectAll() {
        List<IncomeOutcome> io= incomeMapper.selectAll();

        return null;
    }

    @Override
    public IncomeOutcomeDTO selectOne(int id) {
        return null;
    }

    @Override
    public int insert(IncomeOutcomeDTO ioDTO) {
        return 0;
    }

    @Override
    public int update(IncomeOutcomeDTO ioDTO) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
