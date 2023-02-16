package kr.co.ahaproject.apicontroller.jyh;

import kr.co.ahaproject.dto.BoardDTO;
import org.springframework.http.ResponseEntity;



public interface BoardApiController {

	 ResponseEntity create(BoardDTO dto);

	 ResponseEntity update(BoardDTO dto);
	
	 ResponseEntity delete(BoardDTO dto);
	 
}
