package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.mskim.CardApiController;
import kr.co.ahaproject.dto.CardDTO;
import kr.co.ahaproject.service.mskim.CardService;


@RestController
@RequestMapping("/api/user/basicinfo/card")
public class CardApiControllerImpl implements CardApiController {
	
	@Autowired
	private CardService cardService;

	@Override
	@PostMapping("/cardinfo")
	public ResponseEntity<CardDTO> register(@RequestBody CardDTO cardDTO) {
		
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
	@PutMapping("/cardinfo")
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
	@DeleteMapping("/cardinfo")
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
