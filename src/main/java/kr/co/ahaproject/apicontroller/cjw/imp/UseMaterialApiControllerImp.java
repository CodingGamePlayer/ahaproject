package kr.co.ahaproject.apicontroller.cjw.imp;

import kr.co.ahaproject.apicontroller.cjw.UseMaterialApiController;
import kr.co.ahaproject.dto.UseMaterialDTO;
import kr.co.ahaproject.service.cjw.MaterialService;
import kr.co.ahaproject.service.cjw.UseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/worksite")
public class UseMaterialApiControllerImp implements UseMaterialApiController{


	private final UseMaterialService useMaterialService;

	private final MaterialService materialService;
	
	@Override
	@PostMapping("/useMaterial")
	public ResponseEntity register(@RequestBody UseMaterialDTO useMaterialDTO) {

		if(useMaterialDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        int result = useMaterialService.create(useMaterialDTO);


        if(result == 0){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@PutMapping("/useMaterial")
	public ResponseEntity update(@RequestBody UseMaterialDTO useMaterialDTO) {
		int result = useMaterialService.update(useMaterialDTO);

		if (result == 0){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@DeleteMapping("/useMaterial")
	public ResponseEntity delete(@RequestBody UseMaterialDTO useMaterialDTO) {

		int result = useMaterialService.delete(useMaterialDTO);
        
		if (result == 0){ 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

        return ResponseEntity.status(HttpStatus.OK).build();
	}

}
