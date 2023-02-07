package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.AdminApiController;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.MisuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminApiControllerImp implements AdminApiController {

    @Autowired
    private MisuService misuService;



    @Override
    @PostMapping("/misu")
    public ResponseEntity<MisuDTO> register(@RequestBody MisuDTO misuDTO) {

        if(misuDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


        int result = misuService.register(misuDTO);


        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/misu")
    public ResponseEntity<MisuDTO> update(@RequestBody MisuDTO misuDTO) {

        int result = misuService.update(misuDTO);
        log.info(String.valueOf(result));
        if (result == 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
