package kr.co.ahaproject.apicontroller.cjw.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.cjw.MaterialApiController;
import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.service.cjw.MaterialService;

@RestController
@RequestMapping("/api/user")
public class MaterialApiControllerImp implements MaterialApiController {
	
	@Autowired
	private MaterialService materialService;
 
	// 자재 기초등록 - 글생성
	@Override
	@PostMapping("/material")
	public ResponseEntity register(@RequestBody MaterialDTO materialDTO) {

        int result = materialService.create(materialDTO);

        if(result == 0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}

	// 자재 기초등록 - 수정처리
	@Override
	@PutMapping("/material")
	public ResponseEntity update(@RequestBody MaterialDTO materialDTO) {
		
		  int result = materialService.update(materialDTO);

	        if (result == 0){
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	// 자재 기초등록 - 삭제처리
	@Override
	@DeleteMapping("/material")
	public ResponseEntity delete(@RequestBody MaterialDTO materialDTO) {
		
			int mt_id = materialDTO.getMt_id();
			int result = materialService.delete(mt_id);
	        
			if (result == 0){ 
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

	        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
