package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.ClientApiController;
import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.service.kjs.ClientService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ClientApiControllerImp implements ClientApiController {
	
	@Autowired
	private ClientService clientService;
	
	@Override
	@PostMapping("/client")
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
	public ResponseEntity update(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		return null;
	}


}
