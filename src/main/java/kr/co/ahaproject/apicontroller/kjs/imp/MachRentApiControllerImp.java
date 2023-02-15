package kr.co.ahaproject.apicontroller.kjs.imp;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.kjs.MachRentApiController;
import kr.co.ahaproject.dto.MachRentDTO;
import kr.co.ahaproject.service.moo.MachRentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/worksite")
public class MachRentApiControllerImp implements MachRentApiController {

    @Autowired
    private MachRentService machRentService;

    @Override
    @ApiOperation(value = "장비임대 POST", notes = "POST 방식으로 장비임대 등록")
    @PostMapping(value = "/rental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody MachRentDTO machRentDTO) {

        if(machRentService ==  null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        int result = machRentService.register(machRentDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "장비임대 PUT", notes = "PUT 방식으로 장비임대 수정")
    @PutMapping(value = "/rental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MachRentDTO> update(@RequestBody MachRentDTO machRentDTO) {
        int result = machRentService.update(machRentDTO);
        log.info(String.valueOf(result));
        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "장비임대 DELETE", notes = "DELETE 방식으로 장비임대 삭제")
    @DeleteMapping(value = "/rental", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestBody MachRentDTO machRentDTO) {
        int result = machRentService.delete(machRentDTO);

        if (machRentDTO.getRent_id() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (result==0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
