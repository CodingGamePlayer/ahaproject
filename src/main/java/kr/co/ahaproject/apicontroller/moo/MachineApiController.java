package kr.co.ahaproject.apicontroller.moo;

import kr.co.ahaproject.dto.MachineDTO;
import org.springframework.http.ResponseEntity;

public interface MachineApiController {

    ResponseEntity register(MachineDTO machineDTO);

    ResponseEntity update(MachineDTO machineDTO);

    ResponseEntity delete(MachineDTO machineDTO);
}
