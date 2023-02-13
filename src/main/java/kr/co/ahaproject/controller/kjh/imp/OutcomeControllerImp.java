package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.OutcomeController;
import kr.co.ahaproject.service.kjh.OutcomeService;
import kr.co.ahaproject.service.kjh.OutcomeService;
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
public class OutcomeControllerImp implements OutcomeController {

    @Autowired
    OutcomeService outcomeService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ClientService clientService;
    @Autowired
    ConstructionService constructionService;

    @Override
    @GetMapping("/outcome")
    public String selectAll(Model model) {

        model.addAttribute("outDTOs", outcomeService.selectAll());
        return "user/accounting/outcome/list";
    }

    @Override
    @GetMapping("/outcome-form")
    public String registerForm(Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constructionService.selectAll());
        return "user/accounting/outcome/form";
    }


    @Override
    @GetMapping("/outcome-edit")
    public String editForm(long out_id, Model model) {
        model.addAttribute("outDTO", outcomeService.selectOne(out_id));
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constructionService.selectAll());
        return "user/accounting/outcome/edit-form";
    }
}
