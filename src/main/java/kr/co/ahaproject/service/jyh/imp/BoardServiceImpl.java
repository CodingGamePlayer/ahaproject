package kr.co.ahaproject.service.jyh.imp;

import java.util.List;

import kr.co.ahaproject.service.jyh.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.mapper.jyh.Boardmapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	
	@Autowired
	Boardmapper mapper;
	

	@Override
	public List<BoardDTO> listAll() {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}

	@Override
	public int create(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.create(dto);
	}

	@Override
	public BoardDTO SelectOne(int b_id) {
		// TODO Auto-generated method stub
		return mapper.SelectOne(b_id);
	}

	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}

	@Override
	public int delete(int b_id) {
		// TODO Auto-generated method stub
		return mapper.delete(b_id);
	}
	
	

}
