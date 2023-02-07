package kr.co.ahaproject.controller.kjs.imp;

import java.text.Format;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ahaproject.controller.kjs.ClientController;
import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.imp.ClientServiceImp;

@Controller
@RequestMapping("/user/client")
public class ClientControllerImp implements ClientController {
	
	@Autowired
	private ClientServiceImp clientService;
	
	@Autowired
	private CompanyService companyService;
	
	
	
//	전체목록조회	
	@Override
	@GetMapping("/list")
	public String client(Model model) {
		// TODO Auto-generated method stub
		List<ClientDTO> list = clientService.selectAll();
		model.addAttribute("clients", list);
		return "user/client/list";
	}

//	작성페이지 이동
	@Override
	@GetMapping("/form")
	public String clientForm(Model model,ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		
		List<CompanyDTO> companyList = companyService.selectAll();
		model.addAttribute("companys", companyList);
		return "user/client/form";
	}

	@Override
	public String clientEditForm(MisuDTO misuDTO, Model model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
