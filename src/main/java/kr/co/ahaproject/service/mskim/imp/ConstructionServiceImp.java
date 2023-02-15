package kr.co.ahaproject.service.mskim.imp;

import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Construction;
import kr.co.ahaproject.mapper.mskim.ConstructionMapper;
import kr.co.ahaproject.service.mskim.ConstructionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConstructionServiceImp implements ConstructionService {

    @Autowired
    private ConstructionMapper constructionMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ConstructionDTO> selectAll() {

        List<Construction> constructionList = constructionMapper.selectAll();

        return constructionList.stream()
                .map(construction -> modelMapper.map(construction, ConstructionDTO.class))
                .collect(Collectors.toList());
    }

	@Override
	public ConstructionDTO findByCst(ConstructionDTO cstDTO) {
		
		Construction cst = constructionMapper.findByCst(modelMapper.map(cstDTO, Construction.class));
		
		return modelMapper.map(cst, ConstructionDTO.class);
	}

	@Override
	public int regist(ConstructionDTO cstDTO) {
		
		int result = constructionMapper.register(modelMapper.map(cstDTO, Construction.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int update(ConstructionDTO cstDTO) {
		
		int result = constructionMapper.update(modelMapper.map(cstDTO, Construction.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public int delete(ConstructionDTO cstDTO) {

		int result = constructionMapper.delete(modelMapper.map(cstDTO, Construction.class));
		
		if(!(result>0)) {
			return 0;
		}
		
		return 1;
	}


	@Override
	public int codeCount() {
		
		
		return constructionMapper.codeCount();
	}

	@Override
	public PageResponseDTO<ConstructionDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

		List<Construction> constructions = constructionMapper.selectAllForPaging(pageRequestDTO);

		List<ConstructionDTO> dtoList = constructions.stream()
				.map(construction -> modelMapper.map(construction, ConstructionDTO.class))
				.collect(Collectors.toList());

		int total = constructionMapper.getCount(pageRequestDTO);

		PageResponseDTO<ConstructionDTO> pageResponseDTO = PageResponseDTO.<ConstructionDTO>withAll()
				.pageRequestDTO(pageRequestDTO)
				.total(total)
				.dtoList(dtoList)
				.build();

		return pageResponseDTO;
	}
}
