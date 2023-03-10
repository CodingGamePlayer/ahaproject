package kr.co.ahaproject.service.jyh;

import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.dto.ReplyListDTO;

import java.util.List;


public interface ReplyService {
	
	//댓글 전체조회
	List<ReplyDTO> getdetail(int b_id);
		
	//글 작성
	public int create(ReplyDTO dto);
			
		
	//해당 글 선택조회
	public ReplyDTO SelectOne(int rp_id);
			
			
		
		
	//글 수정
	public int update(ReplyDTO dto); 
			
		
		
	//글 삭제
	public int delete(int rp_id);

	List<ReplyListDTO> findByBoardId(int id);
			
		
	
	

	
}
