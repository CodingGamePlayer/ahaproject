package kr.co.ahaproject.apicontroller.moo.imp;

import kr.co.ahaproject.apicontroller.moo.MachRentApiController;
import kr.co.ahaproject.dto.MachRentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/worksite")
public class MachRentApiControllerImp implements MachRentApiController {


    @Override
    @PostMapping("/rental")
    public ResponseEntity register(MachRentDTO machRentDTO) {

        return null;
    }

    @Override
    public ResponseEntity update(MachRentDTO machRentDTO) {
        return null;
    }

    @Override
    public ResponseEntity delete(MachRentDTO machRentDTO) {
        return null;
    }
}
