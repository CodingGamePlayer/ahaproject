package kr.co.ahaproject.service.kjs;

import java.util.List;

import kr.co.ahaproject.dto.MaterialDTO;

public interface MaterialService {
	
		// 자재 기초정보 전체조회
		List<MaterialDTO> listAll();
		
		// 자재 기초정보 선택조회
		MaterialDTO selectOne(int mt_id);
		
		// 자재 기초정보 글작성
		int create(MaterialDTO dto);
		
		// 자재 기초정보 글수정
		int update(MaterialDTO dto);
		
		// 자재 기초정보 글삭제
		int delete(int mt_id);

}
