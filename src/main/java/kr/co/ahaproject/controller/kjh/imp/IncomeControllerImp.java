package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting")
public class IncomeControllerImp implements IncomeController {
    @Autowired
    IncomeService incomeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ClientService clientService;
    @Autowired
    ConstructionService constructionService;

    @Override
    @GetMapping("/income")
    public String selectAll(String cl_code,Model model) {

        model.addAttribute("ioDTOs", incomeService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        return "user/accounting/income/list";
    }

    @Override
    @GetMapping("/income-form")
    public String registerForm(Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constructionService.selectAll());
        return "user/accounting/income/form";
    }


    @Override
    @GetMapping("/income-edit")
    public String editForm(long io_id, Model model) {
        model.addAttribute("ioDTO", incomeService.selectOne(io_id));
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constructionService.selectAll());
        return "user/accounting/income/edit-form";
    }

    @Override
    @GetMapping ("/incomeclcode/{cl_code}")
    public String findByClcode(@PathVariable String cl_code, Model model) {

        model.addAttribute("ioDTOs", incomeService.findByClcode(cl_code));

        return "user/accounting/income/";
    }


}

