package kr.co.ahaproject.apicontroller.moo;

import kr.co.ahaproject.dto.MachRentDTO;
import org.springframework.http.ResponseEntity;

public interface MachRentApiController {
    ResponseEntity register(MachRentDTO machRentDTO);

    ResponseEntity update(MachRentDTO machRentDTO);

    ResponseEntity delete(MachRentDTO machRentDTO);
}
