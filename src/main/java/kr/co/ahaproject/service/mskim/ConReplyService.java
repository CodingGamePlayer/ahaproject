package kr.co.ahaproject.service.mskim;

import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;

public interface ConReplyService {
	
	PageResponseDTO<ConReplyDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
	
	ConReplyDTO selectOne(ConReplyDTO conReplyDTO);
	
	int regist(ConReplyDTO conReplyDTO);
	
	int update(ConReplyDTO conReplyDTO);
	
	int delete(ConReplyDTO conReplyDTO);

}
