package kr.co.ahaproject.apicontroller.cjw.imp;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.cjw.UseMaterialApiController;
import kr.co.ahaproject.dto.UseMaterialDTO;
import kr.co.ahaproject.service.cjw.UseMaterialService;

@RestController
@RequestMapping("/api/user/worksite")
public class UseMaterialApiControllerImp implements UseMaterialApiController{

	@Autowired
	private UseMaterialService useMaterialService;
	
	@Override
	@PostMapping("/useMaterial")
	public ResponseEntity register(@RequestBody UseMaterialDTO useMaterialDTO) {

		if(useMaterialDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        int result = useMaterialService.create(useMaterialDTO);


        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@PutMapping("/useMaterial")
	public ResponseEntity update(@RequestBody UseMaterialDTO useMaterialDTO) {
		int result = useMaterialService.update(useMaterialDTO);
		  System.out.println(String.valueOf(result));
	        
	        if (result == 0){
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }

	        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@DeleteMapping("/useMaterial")
	public ResponseEntity delete(@RequestBody UseMaterialDTO useMaterialDTO) {
		Long um_id = useMaterialDTO.getUm_id();
		int result = useMaterialService.delete(um_id);
        
		if (result == 0){ 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); 
		}

        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
