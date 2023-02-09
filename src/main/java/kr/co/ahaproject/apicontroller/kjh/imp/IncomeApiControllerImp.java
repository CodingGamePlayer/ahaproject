package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.IncomeApiController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user/accounting/income")
public class IncomeApiControllerImp implements IncomeApiController {
    @Autowired
    IncomeService incomeService;
    @Override
    @PostMapping("/register")
    public ResponseEntity<IncomeOutcomeDTO> register(@RequestBody IncomeOutcomeDTO ioDTO) {

        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
        if(ioDTO1==null){
            ioDTO.setIn_total_value(ioDTO.getIn_supp_value());
            ioDTO.setIn_collect_remain(ioDTO.getIn_supp_value()-ioDTO.getIn_collect_value());
            return null;
        }
        ioDTO.setIn_total_value(ioDTO1.getIn_total_value()+ioDTO.getIn_supp_value());
        ioDTO.setIn_collect_remain(ioDTO1.getIn_collect_remain()+ioDTO.getIn_supp_value()-ioDTO.getIn_collect_value());
        return null;
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<IncomeOutcomeDTO> update(@RequestBody IncomeOutcomeDTO ioDTO) {
        return null;
    }

    @Override
    @DeleteMapping("")
    public ResponseEntity<IncomeOutcomeDTO> delete(@RequestBody IncomeOutcomeDTO ioDTO) {
        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
        incomeService.delete(ioDTO);
        if(ioDTO1.getIo_id()==ioDTO.getIo_id()){
            return null;
        }
        //삭제할때 최근꺼라면
        //추가할때 기존게 없으면
//        List<IncomeOutcomeDTO> list = incomeService.selectAllmod(ioDTO);
//
//        for (IncomeOutcomeDTO io : list) {
//
//            io.setIn_total_value(io.getIn_total_value()-ioDTO.getIn_supp_value());
//            io.setIn_collect_remain();
//            incomeService.update(io);
//        }
        ioDTO1.setIn_total_value(ioDTO1.getIn_total_value()-ioDTO.getIn_supp_value());
        ioDTO1.setIn_collect_remain(ioDTO1.getIn_collect_remain()-ioDTO.getIn_supp_value()+ioDTO.getIn_collect_value());
        incomeService.update(ioDTO1);
        return null;
    }


}
