package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.ClientApiController;
import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.service.kjs.ClientService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ClientApiControllerImp implements ClientApiController {
	
	@Autowired
	private ClientService clientService;
	
	@Override
	@Operation(summary = "register for client,post", description = "고객정보 등록")
	@PostMapping(value="/client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDTO> register(@RequestBody ClientDTO clientDTO) {

		if(clientDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = clientService.register(clientDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@Operation(summary = "update for client,put", description = "고객정보 수정")
	@PutMapping(value="/client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		 
		int result = clientService.update(clientDTO);
		log.info(String.valueOf(result));
		if (result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
		
	        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@Operation(summary = "delete for client,delete", description = "고객정보 삭제")
	@DeleteMapping(value="/client", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDTO> delete(@RequestBody ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		int result = clientService.delete(clientDTO);
		log.info(String.valueOf(result));
		if (result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
		
	        return ResponseEntity.status(HttpStatus.OK).build();
		
	}
}
