package kr.co.ahaproject.service.jyh.imp;

import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.dto.ReplyListDTO;
import kr.co.ahaproject.mapper.jyh.Replymapper;
import kr.co.ahaproject.service.jyh.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	Replymapper mapper;

	@Override
	public List<ReplyDTO> getdetail(int b_id) {
		// TODO Auto-generated method stub
		return mapper.getdetail(b_id);
	}

	@Override
	public int create(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.replycreate(dto);
	}

	@Override
	public ReplyDTO SelectOne(int rp_id) {
		// TODO Auto-generated method stub
		return mapper.replySelectOne(rp_id);
	}

	@Override
	public int update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return mapper.replyupdate(dto);
	}

	@Override
	public int delete(int rp_id) {
		// TODO Auto-generated method stub
		return mapper.replydelete(rp_id);
	}

	@Override
	public List<ReplyListDTO> findByBoardId(int id) {


		return mapper.findByBoardId(id);
	}
}
