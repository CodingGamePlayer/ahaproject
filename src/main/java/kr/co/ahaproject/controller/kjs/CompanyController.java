package kr.co.ahaproject.controller.kjs;


import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.springframework.ui.Model;

public interface CompanyController {
	
	
	String company(PageRequestDTO pageRequestDTO, Model model);

    String companyForm(Model model, CompanyDTO companyDTO);

    String compnayEditForm(Model model, CompanyDTO companyDTO);
	
		

}
