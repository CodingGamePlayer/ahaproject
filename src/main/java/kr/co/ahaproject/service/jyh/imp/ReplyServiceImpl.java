package kr.co.ahaproject.service.jyh.imp;

import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.dto.ReplyListDTO;
import kr.co.ahaproject.mapper.jyh.Replymapper;
import kr.co.ahaproject.service.jyh.BoardService;
import kr.co.ahaproject.service.jyh.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	private final Replymapper replymapper;

	private final BoardService boardService;

	@Override
	public List<ReplyDTO> getdetail(int b_id) {
		// TODO Auto-generated method stub
		return replymapper.getdetail(b_id);
	}

	@Override
	public int create(ReplyDTO dto) {

		BoardDTO boardDTO = boardService.SelectOne(dto.getB_id());
		boardDTO.setB_finished(true);
		boardService.updateFinish(boardDTO);

		return replymapper.replycreate(dto);
	}

	@Override
	public ReplyDTO SelectOne(int rp_id) {
		// TODO Auto-generated method stub
		return replymapper.replySelectOne(rp_id);
	}



	@Override
	public int update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		return replymapper.replyupdate(dto);
	}

	@Override
	public int delete(int rp_id) {
		// TODO Auto-generated method stub
		return replymapper.replydelete(rp_id);
	}

	@Override
	public List<ReplyListDTO> findByBoardId(int id) {


		return replymapper.findByBoardId(id);
	}
}
