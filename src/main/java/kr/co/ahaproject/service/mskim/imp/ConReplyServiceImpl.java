package kr.co.ahaproject.service.mskim.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.ConReply;
import kr.co.ahaproject.mapper.mskim.ConReplyMapper;
import kr.co.ahaproject.service.mskim.ConReplyService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConReplyServiceImpl implements ConReplyService {
	
	@Autowired
	private ConReplyMapper conReplyMapper;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public PageResponseDTO<ConReplyDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {
		
		List<ConReplyDTO> conReplyDTOs = conReplyMapper.selectAllForPaging(pageRequestDTO);
		
		int total = conReplyMapper.getCount(pageRequestDTO);
		
		PageResponseDTO<ConReplyDTO> pageResponseDTO = PageResponseDTO.<ConReplyDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.dtoList(conReplyDTOs)
				.total(total)
				.build();
		
		
		return pageResponseDTO;
	}


	@Override
	public int regist(ConReplyDTO conReplyDTO) {
		
		int result = conReplyMapper.regist(modelMapper.map(conReplyDTO, ConReply.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}


	@Override
	public ConReplyDTO selectOne(ConReplyDTO conReplyDTO) {
		
		
		
		return conReplyMapper.selectOne(conReplyDTO);
	}


	@Override
	public int update(ConReplyDTO conReplyDTO) {
		
		int result = conReplyMapper.update(modelMapper.map(conReplyDTO, ConReply.class));
		
		if(!(result>0)) {
			return 0;
		}
		return 1;
	}


	@Override
	public int delete(ConReplyDTO conReplyDTO) {
		int result = conReplyMapper.delete(modelMapper.map(conReplyDTO, ConReply.class));
		
		if(!(result>0)) {
			return 0;
		}
		return 1;
	}
	

}
