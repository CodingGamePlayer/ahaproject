package kr.co.ahaproject.apicontroller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.ahaproject.apicontroller.jyh.BoardApiController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.service.jyh.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class BoardApiControllerImpl implements BoardApiController{
	
	@Autowired
	private BoardService service;

	@Override
	@PostMapping("/board")
	public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO dto) {
		System.out.println("API 컨트롤러 테스트 로그");
		
		  if(dto == null){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }


	        int result = service.create(dto);


	        if(result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@PutMapping("/board")
	public ResponseEntity<BoardDTO> update(@RequestBody BoardDTO dto) {
	    int result = service.update(dto);
        log.info(String.valueOf(result));
        if (result == 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
