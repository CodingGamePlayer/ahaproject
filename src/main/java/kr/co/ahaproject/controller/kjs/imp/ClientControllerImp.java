package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.ClientController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.imp.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/client")
public class ClientControllerImp implements ClientController {
	

	private ClientServiceImp clientService;
	private CompanyService companyService;



//	전체목록조회	
	@Override
	@GetMapping("/list")
	public String client(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {

		PageResponseDTO<ClientDTO> pageResponseDTO = clientService.selectAllForPaging(pageRequestDTO);


		model.addAttribute("clients", pageResponseDTO);
		return "user/client/client-list";
	}

//	작성페이지 이동
	@Override
	@GetMapping("/form")
	public String clientForm(Model model,ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		
		List<CompanyDTO> companyList = companyService.selectAll();
		model.addAttribute("companys", companyList);
		int rs = clientService.maxNum();
		String maxNum = String.format("%04d", rs); // % 0Xd >> 0x X자리 > 0000 
		model.addAttribute("maxNum", maxNum);
		return "user/client/client-form";
	}

//	수정페이지 이동
	@Override
	@GetMapping("/edit")
	public String clientEditForm(Model model, ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		
		 ClientDTO rs = clientService.findById(clientDTO); 
		 List<CompanyDTO> companyList = companyService.selectAll(); 
		 model.addAttribute("client", rs);
		 model.addAttribute("companys", companyList);
		 
		
		return "user/client/client-edit";
	}

	@Autowired
	public ClientControllerImp(ClientServiceImp clientService, CompanyService companyService) {
		this.clientService = clientService;
		this.companyService = companyService;
	}
}
