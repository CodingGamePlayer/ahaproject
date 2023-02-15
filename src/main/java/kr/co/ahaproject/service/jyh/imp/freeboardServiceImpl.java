package kr.co.ahaproject.service.jyh.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.mapper.jyh.freeboardmapper;
import kr.co.ahaproject.service.jyh.freeboardService;

@Service
public class freeboardServiceImpl implements freeboardService {
	
	@Autowired
	freeboardmapper Freeboardmapper;

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return Freeboardmapper.listAll();
	}

	@Override
	public int register(BoardDTO dto) {
		// TODO Auto-generated method stub
		return Freeboardmapper.create(dto);
	}

	@Override
	public BoardDTO SelectOne(int b_id) {
		// TODO Auto-generated method stub
		return Freeboardmapper.SelectOne(b_id);
	}

	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return Freeboardmapper.update(dto);
	}

	@Override
	public int delete(int b_id) {
		// TODO Auto-generated method stub
		return Freeboardmapper.delete(b_id);
	}
}
