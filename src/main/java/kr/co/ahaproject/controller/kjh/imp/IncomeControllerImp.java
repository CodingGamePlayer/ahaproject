package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import kr.co.ahaproject.service.kjh.IncomeService;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
    public String selectAll(Model model) {

        model.addAttribute("inDTOs", incomeService.selectAll());
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
    public String editForm(long in_id, Model model) {
        model.addAttribute("inDTO", incomeService.selectOne(in_id));
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constructionService.selectAll());
        return "user/accounting/income/edit-form";
    }





}

