package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.OutcomeApiController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import kr.co.ahaproject.service.kjh.OutcomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/accounting")
public class OutcomeApiControllerImp implements OutcomeApiController {
    @Autowired
    OutcomeService outcomeService;
    @Override
    @PostMapping("/outcome")
    public ResponseEntity<IncomeOutcomeDTO> register(@RequestBody IncomeOutcomeDTO ioDTO) {
        int result = outcomeService.insert(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/outcome")
    public ResponseEntity<IncomeOutcomeDTO> update(@RequestBody IncomeOutcomeDTO ioDTO) {
        int result = outcomeService.update(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping ("/outcome")
    public ResponseEntity delete(@RequestBody IncomeOutcomeDTO ioDTO) {
        int result = outcomeService.delete(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
