package kr.co.ahaproject.service.cjw.imp;

import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Material;
import kr.co.ahaproject.entity.UseMaterial;
import kr.co.ahaproject.mapper.cjw.MaterialMapper;
import kr.co.ahaproject.mapper.cjw.UseMaterialMapper;
import kr.co.ahaproject.service.cjw.UseMaterialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UseMaterialServiceImp implements UseMaterialService {

	// 현장 자재 서비스
	private final UseMaterialMapper useMaterialMapper;
	private final MaterialMapper materialMapper;

	private final ModelMapper modelMapper = new ModelMapper();

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

		UseMaterialDTO useMaterialDTO = useMaterialMapper.selectOne(dto.getUm_id());

		if(useMaterialDTO == null){
			return 0;
		}


		return useMaterialMapper.update(useMaterialDTO);
	}

	@Override
	public int delete(UseMaterialDTO useMaterialDTO) {

		UseMaterialDTO result = useMaterialMapper.selectOne(useMaterialDTO.getUm_id());
		Material target = materialMapper.findByCode(useMaterialDTO.getMt_code());

		target.setMt_remain(target.getMt_remain() + result.getUm_amount());
		MaterialDTO materialDTO = modelMapper.map(target, MaterialDTO.class);
		materialMapper.update(materialDTO);

		return useMaterialMapper.delete(useMaterialDTO.getUm_id());
	}

	@Override
	public int selectCount() {
		return useMaterialMapper.selectCount();
	}


	@Override
	public PageResponseDTO<UseMaterialDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

		List<UseMaterial> materialList = useMaterialMapper.selectAllForPaging(pageRequestDTO);

		List<UseMaterialDTO> collect = materialList.stream()
				.map(useMaterial -> modelMapper.map(useMaterial, UseMaterialDTO.class))
				.collect(Collectors.toList());

		int count = useMaterialMapper.getCount(pageRequestDTO);

		PageResponseDTO<UseMaterialDTO> pageResponseDTO = PageResponseDTO.<UseMaterialDTO>withAll()
				.dtoList(collect)
				.total(count)
				.pageRequestDTO(pageRequestDTO)
				.build();

		return pageResponseDTO;
	}
}
