package kr.co.ahaproject.apicontroller.moo.imp;
import kr.co.ahaproject.apicontroller.moo.MachineApiController;
import kr.co.ahaproject.dto.MachineDTO;
import kr.co.ahaproject.service.moo.MachineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class MachineApiControllerImp implements MachineApiController {

    @Autowired
    private MachineService machineService;



}
