package kr.co.ahaproject.apicontroller.moo;

import kr.co.ahaproject.dto.MachineDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MachineApiController {

    ResponseEntity register(MachineDTO machineDTO);

    ResponseEntity update(MachineDTO machineDTO);
}
