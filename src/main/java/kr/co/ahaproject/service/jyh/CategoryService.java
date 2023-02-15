package kr.co.ahaproject.service.jyh;

import java.util.List;
import kr.co.ahaproject.dto.CategoryDTO;

public interface CategoryService {

	//전체조회
		List<CategoryDTO> listAll();
			
		//글 작성
		public int create(CategoryDTO dto);
				
			
		//해당 글 선택조회
		public CategoryDTO SelectOne(int ct_id);
				
				
			
			
		//글 수정
		public int update(CategoryDTO dto); 
				
			
			
		//글 삭제
		public int delete(int ct_id);
				
			
			
			
		
}
