package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.mskim.CardApiController;
import kr.co.ahaproject.dto.CardDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.mskim.CardService;


@RestController
@RequestMapping("/api/user/basicinfo/card")
public class CardApiControllerImpl implements CardApiController {
	
	@Autowired
	private CardService cardService;

	@Override
	@ApiOperation(value="카드 POST", notes="fetch를 이용하여 POST방식으로 카드정보 등록" )
	@PostMapping(value="/cardinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardDTO> register(@RequestBody CardDTO cardDTO) {
		
		String after = new AhaCommonMethod().changeDate(cardDTO.getCard_exp_date());
		cardDTO.setCard_exp_date(after);
		
		if(cardDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cardService.register(cardDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="카드 PUT", notes="fetcf를 이용하여 PUT방식으로 카드정보 수정")
	@PutMapping(value="/cardinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardDTO> update(@RequestBody CardDTO cardDTO) {
		
		if(cardDTO ==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cardService.update(cardDTO);
		
		if(result==0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@ApiOperation(value="카드 DELETE", notes="fetch를 이용하여 DELETE방식으로 카드정보 삭제")
	@DeleteMapping(value="/cardinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CardDTO> delete(@RequestBody CardDTO cardDTO) {
		
		if(cardDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = cardService.delete(cardDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	

}
