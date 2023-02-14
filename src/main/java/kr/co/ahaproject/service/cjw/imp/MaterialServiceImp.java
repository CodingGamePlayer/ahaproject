package kr.co.ahaproject.service.cjw.imp;

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Material;
import kr.co.ahaproject.mapper.cjw.MaterialMapper;
import kr.co.ahaproject.service.cjw.MaterialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImp implements MaterialService{
	
	@Autowired
	MaterialMapper materialMapper;

	private ModelMapper modelMapper = new ModelMapper();
	
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

	// count
	@Override
	public int selectCount() {
		return materialMapper.selectCount();
	}


	@Override
	public PageResponseDTO<MaterialDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

		List<Material> materialList = materialMapper.selectAllForPaging(pageRequestDTO);

		List<MaterialDTO> collect = materialList.stream()
				.map(material -> modelMapper.map(material, MaterialDTO.class))
				.collect(Collectors.toList());

		int count = materialMapper.getCount(pageRequestDTO);

		PageResponseDTO<MaterialDTO> pageResponseDTO = PageResponseDTO.<MaterialDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.total(count)
				.dtoList(collect)
				.build();

		return pageResponseDTO;
	}
}
