package kr.co.ahaproject.apicontroller.jyh;

import org.springframework.http.ResponseEntity;
import kr.co.ahaproject.dto.CategoryDTO;

public interface CategoryboardApiController {

	 ResponseEntity create(CategoryDTO dto);

	 ResponseEntity update(CategoryDTO dto);
	
	 ResponseEntity delete(CategoryDTO dto);
}
