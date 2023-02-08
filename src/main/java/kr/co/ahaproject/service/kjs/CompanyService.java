package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CompanyDTO;

import java.util.List;

import groovyjarjarpicocli.CommandLine.Model;

public interface CompanyService {

    List<CompanyDTO> selectAll();
    
    CompanyDTO findById(CompanyDTO companyDTO);
    
    int register(CompanyDTO companyDTO);

    int update(CompanyDTO companyDTO);
    
}
