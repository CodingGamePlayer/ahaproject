package kr.co.ahaproject.apicontroller.moo.imp;
import kr.co.ahaproject.apicontroller.moo.MachineApiController;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.moo.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if(machineDTO ==  null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        int result = machineService.register(machineDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/machine")
    public ResponseEntity<MachineDTO> update(@RequestBody MachineDTO machineDTO) {

        int result = machineService.update(machineDTO);
        log.info(String.valueOf(result));
        log.info(String.valueOf(machineDTO));
        if(result == 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
