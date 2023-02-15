package kr.co.ahaproject.service.jyh;

import java.util.List;


import kr.co.ahaproject.dto.BoardDTO;





public interface BoardService {
	
	
	
	//전체조회
	List<BoardDTO> listAll();
		
	//글 작성
	public int create(BoardDTO dto);
			
		
	//해당 글 선택조회
	public BoardDTO SelectOne(int b_id);
			
			
		
		
		//글 수정
		public int update(BoardDTO dto); 
			
		
		
		//글 삭제
		public int delete(int b_id);
			
		
		
		
	
	
	
	

}
