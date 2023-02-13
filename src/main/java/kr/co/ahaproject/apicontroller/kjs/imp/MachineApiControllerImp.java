package kr.co.ahaproject.apicontroller.kjs.imp;
import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.kjs.MachineApiController;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.kjs.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class MachineApiControllerImp implements MachineApiController {

    @Autowired
    private MachineService machineService;


    @Override
    @PostMapping("/machine")
    public ResponseEntity register(@RequestBody MachineDTO machineDTO) {

        int result = machineService.register(machineDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "장비 PUT", notes = "PUT 방식으로 장비 수정")
    @PutMapping(value = "/machine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MachineDTO> update(@RequestBody MachineDTO machineDTO) {

        int result = machineService.update(machineDTO);
        log.info(String.valueOf(result));
        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "장비 DELETE", notes = "DELETE 방식으로 장비 삭제")
    @DeleteMapping(value = "/machine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestBody MachineDTO machineDTO) {
        int result = machineService.delete(machineDTO);

        if (machineDTO.getM_id() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (result==0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
