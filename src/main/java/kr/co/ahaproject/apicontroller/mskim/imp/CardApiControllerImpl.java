package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.mskim.CardApiController;
import kr.co.ahaproject.dto.CardDTO;


@RestController
@RequestMapping("/api/user/basicinfo/card")
public class CardApiControllerImpl implements CardApiController {

	@Override
	public ResponseEntity register(CardDTO cardDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity update(CardDTO cardDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
