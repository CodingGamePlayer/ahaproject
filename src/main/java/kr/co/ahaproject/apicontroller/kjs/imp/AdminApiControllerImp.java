package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.AdminApiController;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.MisuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
