package kr.co.ahaproject.apicontroller.kjs.imp;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.kjs.AdminApiController;
import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.AccountService;
import kr.co.ahaproject.service.kjs.MisuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminApiControllerImp implements AdminApiController {

    @Autowired
    private MisuService misuService;
    @Autowired
    private AccountService accountService;


    @Override
    @ApiOperation(value = "미수금 POST", notes = "POST 방식으로 미수금 등록")
    @PostMapping(value = "/misu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MisuDTO> register(@RequestBody MisuDTO misuDTO) {

        if(misuDTO.getMisu_uuid() == null){
            misuDTO.setMisu_uuid("");
            misuDTO.setMisu_filename("");
        }

        int result = misuService.register(misuDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "미수금 PUT", notes = "PUT 방식으로 미수금 수정")
    @PutMapping(value = "/misu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MisuDTO> update(@RequestBody MisuDTO misuDTO) {

        int result = misuService.update(misuDTO);
        log.info(String.valueOf(result));
        if (result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "미수금 DELETE", notes = "DELETE 방식으로 미수금 삭제")
    @DeleteMapping(value = "/misu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestBody MisuDTO misuDTO) {

        int result = misuService.delete(misuDTO);

        if (misuDTO.getMisu_id() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (result==0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "권한 PUT", notes = "PUT 방식으로 권한 변경")
    @PutMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeAuth(@RequestBody AccountDTO accountDTO) {

        int result = accountService.changeRole(accountDTO);

        if (result == 0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "계정 DELETE", notes = "DELETE 방식으로 계정 삭제")
    @DeleteMapping(value = "/account", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAccount(@RequestBody AccountDTO accountDTO) {

        int result = accountService.delete(accountDTO);

        if (result==0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @ApiOperation(value = "블랙리스트상태 변경", notes = "PUT 방식으로 블랙리스트 상태 변경")
    @PutMapping("/black")
    public ResponseEntity regitBlack(@RequestBody MisuDTO misuDTO) {

        int result = misuService.regitBlack(misuDTO);

        if (result == 0 ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
