package kr.co.ahaproject.service.mskim.imp;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;
import kr.co.ahaproject.entity.UseCard;
import kr.co.ahaproject.mapper.mskim.UseCardMapper;
import kr.co.ahaproject.service.mskim.UseCardService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UseCardServiceImpl implements UseCardService {
	
	@Autowired
	private UseCardMapper ucm;
	
	private ModelMapper modelMapper = new ModelMapper();
	

	@Override
	public List<UseCardJoinDTO> selectAll() {
		
		
		
		return ucm.selectAll();
	}

	@Override
	public List<UseCardJoinDTO> selectOne(int card_id) {
		
		
		return ucm.selectOne(card_id);
	}

	@Override
	public int regist(UseCardDTO ucDTO) {
		
		int result = ucm.register(modelMapper.map(ucDTO, UseCard.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int update(UseCardDTO ucDTO) {
		int result = ucm.update(modelMapper.map(ucDTO, UseCard.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int delete(UseCardDTO ucDTO) {
		
		int result = ucm.delete(modelMapper.map(ucDTO, UseCard.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public UseCardJoinDTO getFindUcId(int uc_id) {
		
		return ucm.getFindUcId(uc_id);
	}

	@Override
	public PageResponseDTO<UseCardJoinDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

		List<UseCardJoinDTO> useCardJoinDTOS = ucm.selectAllForPaging(pageRequestDTO);

		int total = ucm.getCount(pageRequestDTO);

		PageResponseDTO<UseCardJoinDTO> pageResponseDTO = PageResponseDTO.<UseCardJoinDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.total(total)
				.dtoList(useCardJoinDTOS)
				.build();

		return pageResponseDTO;
	}
}
