package kr.co.ahaproject.apicontroller.kjs.imp;

import kr.co.ahaproject.apicontroller.kjs.AdminApiController;
import kr.co.ahaproject.apicontroller.kjs.ClientApiController;
import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.service.kjs.MisuService;
import kr.co.ahaproject.service.kjs.imp.ClientServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user/client")
public class ClientApiControllerImp implements ClientApiController {

    @Autowired
    private ClientServiceImp Service;



	@Override
	public ResponseEntity register(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity update(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
