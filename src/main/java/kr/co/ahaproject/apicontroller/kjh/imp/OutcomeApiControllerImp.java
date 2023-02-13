package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.OutcomeApiController;
import kr.co.ahaproject.dto.OutcomeDTO;
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
    public ResponseEntity<OutcomeDTO> register(@RequestBody OutcomeDTO outDTO) {
        int result = outcomeService.insert(outDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/outcome")
    public ResponseEntity<OutcomeDTO> update(@RequestBody OutcomeDTO outDTO) {
        int result = outcomeService.update(outDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping ("/outcome")
    public ResponseEntity delete(@RequestBody OutcomeDTO outDTO) {
        int result = outcomeService.delete(outDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
