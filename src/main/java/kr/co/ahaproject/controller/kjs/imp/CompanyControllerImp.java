package kr.co.ahaproject.controller.kjs.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ahaproject.controller.kjs.CompanyController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.kjs.imp.CompanyServiceImp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/company")
public class CompanyControllerImp implements CompanyController {
	
	@Autowired
	private CompanyServiceImp companyService;
	
//	리스트페이지이동
	@Override
	@GetMapping("/list")
	public String company(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("companys",  companyService.selectAll());
		return "user/company/company-list";
	}

//	작성페이지이동
	@Override
	@GetMapping("/form")
	public String companyForm(Model model, CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		
		return "user/company/company-form";
	}

//	수정페이지이동
	@Override
	@GetMapping("/edit")
	public String compnayEditForm(Model model, CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		CompanyDTO rs = companyService.findById(companyDTO);
		model.addAttribute("company", rs);
		return "user/company/company-edit";
	}


	
	

}
