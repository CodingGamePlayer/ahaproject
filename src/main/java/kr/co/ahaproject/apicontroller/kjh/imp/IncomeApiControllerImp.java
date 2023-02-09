package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.IncomeApiController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import kr.co.ahaproject.service.kjh.imp.IncomeServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/accounting")
public class IncomeApiControllerImp implements IncomeApiController {
    @Autowired
    IncomeServiceImp incomeService;
    @Override
    @PostMapping("/income")
    public ResponseEntity<IncomeOutcomeDTO> register(@RequestBody IncomeOutcomeDTO ioDTO) {

        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
        if(ioDTO1.getIo_id()==null) {
            ioDTO.setIn_total_value(ioDTO.getIn_supp_value());
            ioDTO.setIn_collect_remain(ioDTO.getIn_supp_value() - ioDTO.getIn_collect_value());
        } else {
            ioDTO.setIn_total_value(ioDTO1.getIn_total_value()+ioDTO.getIn_supp_value());
            ioDTO.setIn_collect_remain(ioDTO1.getIn_collect_remain()+ioDTO.getIn_supp_value()-ioDTO.getIn_collect_value());
        }
        int result = incomeService.insert(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/income")
    public ResponseEntity<IncomeOutcomeDTO> update(@RequestBody IncomeOutcomeDTO ioDTO) {
        int result = incomeService.update(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Override
    @DeleteMapping ("/income")
    public ResponseEntity delete(@RequestBody IncomeOutcomeDTO ioDTO) {
        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
        int result = incomeService.delete(ioDTO);
        if(ioDTO1.getIo_id()!=ioDTO.getIo_id()){
            ioDTO1.setIn_total_value(ioDTO1.getIn_total_value()-ioDTO.getIn_supp_value());
            ioDTO1.setIn_collect_remain(ioDTO1.getIn_collect_remain()-ioDTO.getIn_supp_value()+ioDTO.getIn_collect_value());
            incomeService.update(ioDTO1);
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

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
