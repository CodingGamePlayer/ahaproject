package kr.co.ahaproject.service.mskim.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.ConstructionDTO;
import kr.co.ahaproject.entity.Construction;
import kr.co.ahaproject.mapper.mskim.ConstructionMapper2;
import kr.co.ahaproject.service.mskim.ConstructionService2;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConstructionServiceImp2 implements ConstructionService2 {

    @Autowired
    private ConstructionMapper2 constructionMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ConstructionDTO> selectAll() {

        List<Construction> constructionList = constructionMapper.selectAll();

        return constructionList.stream()
                .map(construction -> modelMapper.map(construction, ConstructionDTO.class))
                .collect(Collectors.toList());
    }
}
