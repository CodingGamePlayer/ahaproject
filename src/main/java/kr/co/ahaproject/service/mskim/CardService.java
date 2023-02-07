package kr.co.ahaproject.service.mskim;

import java.util.List;

import kr.co.ahaproject.dto.CardDTO;

public interface CardService {
	
	// 전체 카드 리스트
	List<CardDTO> selectAll();
	
	// 거래처별 카드 리스트
	List<CardDTO> findBYClient(String cl_code);
	
	// 카드 디테일
	CardDTO findByCard(int card_id);
	
	// 카드 정보 등록
	int register(CardDTO cardDTO);
	
	// 카드 정보 수정
	int update(CardDTO cardDTO);
	
	// 카드 정보 삭제
	int delete(int card_id);

}
