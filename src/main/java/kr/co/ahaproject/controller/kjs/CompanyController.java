package kr.co.ahaproject.controller.kjs;


import org.springframework.ui.Model;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.CompanyDTO;

public interface CompanyController {
	
	
	String company(Model model);

    String companyForm(Model model, CompanyDTO companyDTO);

    String compnayEditForm(Model model, CompanyDTO companyDTO);
	
		

}
