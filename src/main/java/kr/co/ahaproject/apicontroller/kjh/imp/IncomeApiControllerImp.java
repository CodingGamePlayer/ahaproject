package kr.co.ahaproject.apicontroller.kjh.imp;

import kr.co.ahaproject.apicontroller.kjh.IncomeApiController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/accounting/income")
public class IncomeApiControllerImp implements IncomeApiController {
    @Override
    @PostMapping("/register")
    public ResponseEntity<IncomeOutcomeDTO> register(@RequestBody IncomeOutcomeDTO ioDTO) {
        return null;
    }

    @Override
    @PutMapping("/update")
    public ResponseEntity<IncomeOutcomeDTO> update(@RequestBody IncomeOutcomeDTO ioDTO) {
        return null;
    }
}
