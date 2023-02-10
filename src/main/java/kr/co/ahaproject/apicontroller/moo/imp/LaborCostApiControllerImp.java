package kr.co.ahaproject.apicontroller.moo.imp;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.moo.LaborCostApiController;
import kr.co.ahaproject.dto.LaborCostDTO;
import kr.co.ahaproject.service.moo.LaborCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/user")

public class LaborCostApiControllerImp implements LaborCostApiController {

    @Autowired
    private LaborCostService laborCostService;

    @Override
    @ApiOperation(value = "인건비 POST", notes = "POST 방식으로 인건비 등록")
    @PostMapping("/laborcost")
    public ResponseEntity register(LaborCostDTO laborCostDTO) {
        if (laborCostService == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        int result = laborCostService.register(laborCostDTO);

        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "인건비 PUT", notes = "PUT 방식으로 인건비 수정")
    @PutMapping("/laborcost")
    public ResponseEntity update(LaborCostDTO laborCostDTO) {
        int result = laborCostService.update(laborCostDTO);
        log.info(String.valueOf(result));
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "인건비 DELETE", notes = "DELETE 방식으로 인건비 삭제")
    @DeleteMapping(value = "/laborcost", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(LaborCostDTO laborCostDTO) {
        return null;
    }
}