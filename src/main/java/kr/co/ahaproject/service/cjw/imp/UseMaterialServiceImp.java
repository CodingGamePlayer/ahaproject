package kr.co.ahaproject.service.cjw.imp;

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.dto.UseMaterialDTO;
import kr.co.ahaproject.entity.Material;
import kr.co.ahaproject.mapper.cjw.MaterialMapper;
import kr.co.ahaproject.mapper.cjw.UseMaterialMapper;
import kr.co.ahaproject.service.cjw.UseMaterialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UseMaterialServiceImp implements UseMaterialService {

	// 현장 자재 서비스
	private final UseMaterialMapper useMaterialMapper;
	private final MaterialMapper materialMapper;

	private ModelMapper modelMapper = new ModelMapper();

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

		Material target = materialMapper.findByCode(dto.getMt_code());
		Long mt_remain = target.getMt_remain();
		mt_remain -= dto.getUm_amount();

		if (mt_remain < 0 ){
			return 0;
		}

		target.setMt_remain(mt_remain);
		MaterialDTO changed = modelMapper.map(target, MaterialDTO.class);
		materialMapper.update(changed);

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

	@Override
	public int selectCount() {
		return useMaterialMapper.selectCount();
	}

	
}
