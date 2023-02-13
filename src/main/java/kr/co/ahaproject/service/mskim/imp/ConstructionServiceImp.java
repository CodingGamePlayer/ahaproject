package kr.co.ahaproject.service.mskim.imp;

import kr.co.ahaproject.dto.ConstructionDTO;
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
}
