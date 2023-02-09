package kr.co.ahaproject.service.mskim.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.CardDTO;
import kr.co.ahaproject.entity.Card;
import kr.co.ahaproject.mapper.mskim.CardMapper;
import kr.co.ahaproject.service.kjs.imp.MisuServiceImp;
import kr.co.ahaproject.service.mskim.CardService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardMapper cardMapper;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<CardDTO> selectAll() {
		
		List<Card> cardList = cardMapper.selectAll();
		
		
		return cardList.stream().map(card -> modelMapper.map(card, CardDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CardDTO> findBYClient(String cl_code) {
		
		List<Card> cardList = cardMapper.findByClient(cl_code);
		
		return cardList.stream().map(card -> modelMapper.map(card, CardDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CardDTO findByCard(int card_id) {
		
		Card card = cardMapper.findByCard(card_id);
		
		return modelMapper.map(card, CardDTO.class);
	}

	@Override
	public int register(CardDTO cardDTO) {
		
		int result = cardMapper.register(modelMapper.map(cardDTO, Card.class));
			
		if( !(result >0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int update(CardDTO cardDTO) {
		
		int result = cardMapper.update(modelMapper.map(cardDTO, Card.class));
		
		if( !(result >0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int delete(CardDTO cardDTO) {
		
		int result = cardMapper.delete(modelMapper.map(cardDTO, Card.class));
		
		if( !(result >0)) {
			return 0;
		}
		
		return 1;
	}

}
