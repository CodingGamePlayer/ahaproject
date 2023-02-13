package kr.co.ahaproject.service.mskim.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;
import kr.co.ahaproject.entity.UseCard;
import kr.co.ahaproject.mapper.mskim.UseCardMapper;
import kr.co.ahaproject.service.mskim.UseCardService;
import lombok.extern.slf4j.Slf4j;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(UseCardDTO ucDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
