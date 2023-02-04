package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.entity.Company;
import kr.co.ahaproject.mapper.kjs.CompanyMapper;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CompanyDTO> selectAll() {

        List<Company> companyList = companyMapper.selectAll();

        return companyList.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }
}
