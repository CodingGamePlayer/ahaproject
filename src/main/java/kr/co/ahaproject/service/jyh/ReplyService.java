package kr.co.ahaproject.service.jyh;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.mapper.jyh.Replymapper;

@Service
public class ReplyService {
	
	@Autowired
	Replymapper repmapper;
	
	
	
	//게시판 글에 대한 댓글 조회
	public List<ReplyDTO> getdetail(int b_id){
		
		
		
		return repmapper.getdetail(b_id);
	}
	
	//댓글 선택 조회
	public ReplyDTO replySelectOne(int rp_id) {
		
		return repmapper.replySelectOne(rp_id);
	}
	
	//댓글 작성
	public int replycreate(ReplyDTO dto) {
		
		
		return repmapper.replycreate(dto);
	}
	
	//댓글 수정
	public int replyupdate(ReplyDTO dto) {
		
		
		return repmapper.replyupdate(dto);
	}
	
	//댓글 삭제
	public int replydelete(int rp_id) {
		
		
		return repmapper.replydelete(rp_id);
	}
	
}
