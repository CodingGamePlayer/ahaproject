package kr.co.ahaproject.service.cjw;

import java.util.List;

import kr.co.ahaproject.dto.UseMaterialDTO;


public interface UseMaterialService {
			// 현장 자재 전체조회
			List<UseMaterialDTO> listAll();
			
			// 현장 자재 선택조회
			UseMaterialDTO selectOne(Long um_id);
			
			// 현장 자재 count 수
			int selectCount();
			
			// 현장 자재 글생성
			int create(UseMaterialDTO dto);
			
			// 현장 자재 글수정
			int update(UseMaterialDTO dto);
			
			// 현장 자재 글삭제
			int delete(Long um_id);
}
