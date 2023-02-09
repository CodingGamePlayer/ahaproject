package kr.co.ahaproject.service.cjw.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.UseMaterialDTO;
import kr.co.ahaproject.mapper.cjw.UseMaterialMapper;
import kr.co.ahaproject.service.cjw.UseMaterialService;

@Service
public class UseMaterialServiceImp implements UseMaterialService{

	// 현장 자재 서비스
	@Autowired
	UseMaterialMapper useMaterialMapper;
	
	@Override
	public List<UseMaterialDTO> listAll() {
		return useMaterialMapper.listAll();
	}

	@Override
	public UseMaterialDTO selectOne(Long um_id) {
		return useMaterialMapper.selectOne(um_id);
	}

	@Override
	public int create(UseMaterialDTO dto) {

		return useMaterialMapper.create(dto);
	}

	@Override
	public int update(UseMaterialDTO dto) {
		return useMaterialMapper.update(dto);
	}

	@Override
	public int delete(Long um_id) {
		return useMaterialMapper.delete(um_id);
	}

	
}
