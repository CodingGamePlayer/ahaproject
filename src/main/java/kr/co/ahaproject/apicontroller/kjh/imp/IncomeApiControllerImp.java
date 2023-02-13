package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.IncomeApiController;
import kr.co.ahaproject.dto.IncomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
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
    public ResponseEntity<IncomeDTO> register(@RequestBody IncomeDTO inDTO) {
        int result = incomeService.insert(inDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/income")
    public ResponseEntity<IncomeDTO> update(@RequestBody IncomeDTO inDTO) {
        int result = incomeService.update(inDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping ("/income")
    public ResponseEntity delete(@RequestBody IncomeDTO inDTO) {
        int result = incomeService.delete(inDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
