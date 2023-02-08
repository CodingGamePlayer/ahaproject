package kr.co.ahaproject.service.cjw.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.mapper.cjw.MaterialMapper;
import kr.co.ahaproject.service.cjw.MaterialService;

@Service
public class MaterialServiceImp implements MaterialService{
	
	@Autowired
	MaterialMapper materialMapper;
	
	// 자재 전체조회
	@Override
	public List<MaterialDTO> listAll() {
		System.out.println(materialMapper.listAll());
		return materialMapper.listAll();
	}

	// 자재 선택조회
	@Override
	public MaterialDTO selectOne(int mt_id) {
		return materialMapper.selectOne(mt_id);
	}

	// 자재 글생성
	@Override
	public int create(MaterialDTO dto) {
		return materialMapper.create(dto);
	}

	// 자재 수정
	@Override
	public int update(MaterialDTO dto) {
		return materialMapper.update(dto);
	}

	// 자재 삭제
	@Override
	public int delete(int mt_id) {
		return materialMapper.delete(mt_id);
	}
	
	

}
