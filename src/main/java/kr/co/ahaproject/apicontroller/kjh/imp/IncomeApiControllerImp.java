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
    IncomeService incomeService;
    @Override
    @PostMapping("/income")
    public ResponseEntity<IncomeOutcomeDTO> register(@RequestBody IncomeOutcomeDTO ioDTO) {
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
        int result = incomeService.delete(ioDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
