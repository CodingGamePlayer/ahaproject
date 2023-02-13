package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.entity.Company;
import kr.co.ahaproject.mapper.kjs.CompanyMapper;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

	@Override
	public CompanyDTO findById(CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		Company company = companyMapper.findById(modelMapper.map(companyDTO, Company.class));
		return modelMapper.map(company, CompanyDTO.class);
	}

	@Override
	public int register(CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		int rs = companyMapper.register(modelMapper.map(companyDTO, Company.class));
			if(!(rs>0)) {
				return 0;
			}
		return 1;
	}

	@Override
	public int update(CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		int  rs = companyMapper.update(modelMapper.map(companyDTO, Company.class));
			if(!(rs>0)) return 0;
		return rs;
	}

	@Override
	public int delete(CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		int rs = companyMapper.delete(modelMapper.map(companyDTO, Company.class));
		if(!(rs>0)) return 0;
		return rs;
	}
	
//	페이징 연습중..

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return companyMapper.count();
	}

	@Override
	public List<CompanyDTO> pageList(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		List<Company> companyList = companyMapper.listPage(data);
				
		return companyList.stream()
				.map(company -> modelMapper.map(company, CompanyDTO.class))
				.collect(Collectors.toList());
	}
}

