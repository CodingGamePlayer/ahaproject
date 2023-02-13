package kr.co.ahaproject.apicontroller.jyh.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kr.co.ahaproject.apicontroller.jyh.ReplyApiController;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.service.jyh.ReplyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class ReplyApiControllerImpl implements ReplyApiController {
	
	
	@Autowired
	private ReplyService service;
	
	@Override
	@PostMapping("/board/detail")
	public ResponseEntity<ReplyDTO> create(@RequestBody ReplyDTO dto) {
		System.out.println("API 컨트롤러 테스트 로그");
		
		  if(dto == null){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
		  
		  System.out.println(dto.toString());
	        int result = service.create(dto);


	        if(result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@PutMapping("/board/detail")
	public ResponseEntity<ReplyDTO> update(@RequestBody ReplyDTO dto) {
		System.out.println(dto.getRp_id());
	    int result = service.update(dto);
	    System.out.println(String.valueOf(result));
        if (result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}
	@Override
	@DeleteMapping("/board/detail")
	public ResponseEntity<ReplyDTO> delete(@RequestBody ReplyDTO dto) {
		int rp_id = dto.getRp_id();
		int result = service.delete(rp_id);
		if (result == 0){ 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
		}

        return ResponseEntity.status(HttpStatus.OK).build();
	}
}


	
	
	