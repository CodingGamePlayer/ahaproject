package kr.co.ahaproject.apicontroller.jyh;

import org.springframework.http.ResponseEntity;

import kr.co.ahaproject.dto.BoardDTO;

public interface freeboardApiController {

	 ResponseEntity create(BoardDTO dto);

	 ResponseEntity update(BoardDTO dto);
	
	 ResponseEntity delete(BoardDTO dto);
	 
}