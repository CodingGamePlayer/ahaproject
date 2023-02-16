package kr.co.ahaproject.service.jyh.imp;

import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.BoardListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.mapper.jyh.Boardmapper;
import kr.co.ahaproject.service.jyh.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
		String now = String.valueOf(LocalDate.now());

		dto.setB_regit_date(now);

		return mapper.create(dto);
	}

	@Override
	public BoardDTO SelectOne(int b_id) {
		// TODO Auto-generated method stub
		return mapper.SelectOne(b_id);
	}

	@Override
	public int update(BoardDTO dto) {
		String now = String.valueOf(LocalDate.now());

		dto.setB_modi_date(now);

		return mapper.update(dto);
	}

	@Override
	public int delete(int b_id) {
		// TODO Auto-generated method stub
		return mapper.delete(b_id);
	}

	@Override
	public PageResponseDTO<BoardListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

		List<BoardListDTO> boardListDTOS = mapper.selectAllForPaging(pageRequestDTO);

		int total = mapper.getCount(pageRequestDTO);

		PageResponseDTO<BoardListDTO> pageResponseDTO = PageResponseDTO.<BoardListDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.total(total)
				.dtoList(boardListDTOS)
				.build();

		return pageResponseDTO;
	}
}
