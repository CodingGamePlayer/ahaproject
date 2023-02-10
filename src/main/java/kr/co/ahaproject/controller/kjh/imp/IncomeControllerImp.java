package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.service.kjh.IncomeService;
import kr.co.ahaproject.service.kjh.imp.IncomeServiceImp;
import kr.co.ahaproject.service.kjs.ClientService;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.mskim.ConstructionService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting")
public class IncomeControllerImp implements IncomeController {
    @Autowired
    IncomeServiceImp incomeService;
    @Autowired
    ConstructionService2 constService;
    @Autowired
    ClientService clientService;
    @Autowired
    CompanyService companyService;

    @Override
    @GetMapping("/income")
    public String selectAll(Model model) {
        model.addAttribute("ioDTOs", incomeService.selectAll());
        return "user/accounting/income/list";
    }

    @Override
    @GetMapping("/income-form")
    public String registerForm(Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constService.selectAll());

        return "user/accounting/income/form";
    }


    @Override
    @GetMapping("/income-edit")
    public String editForm(long io_id, Model model) {
        model.addAttribute("ioDTO", incomeService.selectOne( io_id));
        model.addAttribute("companyDTOs", companyService.selectAll());
        model.addAttribute("clientDTOs", clientService.selectAll());
        model.addAttribute("constructionDTOs", constService.selectAll());

        return "user/accounting/income/edit-form";
    }

    @GetMapping("/test")
    public String test1(IncomeOutcomeDTO ioDTO, Model model) {
        IncomeOutcomeDTO ioDTO1 = incomeService.selectRecent(ioDTO);
        System.out.println(ioDTO1.getIo_id());
        if(ioDTO1.getIo_id()==null) {
            ioDTO.setIn_total_value(ioDTO.getIn_supp_value());
            ioDTO.setIn_collect_remain(ioDTO.getIn_supp_value() - ioDTO.getIn_collect_value());
        } else {
            ioDTO.setIn_total_value(ioDTO1.getIn_total_value()+ioDTO.getIn_supp_value());
            ioDTO.setIn_collect_remain(ioDTO1.getIn_collect_remain()+ioDTO.getIn_supp_value()-ioDTO.getIn_collect_value());
        }
        return "user/accounting/income/test";
    }


}

