package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> selectAll();
}
