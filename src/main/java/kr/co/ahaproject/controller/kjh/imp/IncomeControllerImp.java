package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import kr.co.ahaproject.service.kjh.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting/income")
public class IncomeControllerImp implements IncomeController {
    @Autowired
    IncomeService incomeService;

    @Override
    @GetMapping("/list")
    public String selectAll(Model model) {
        model.addAttribute("ioDTOs", incomeService.selectAll());
        return "user/accounting/income/list";
    }

    @Override
    @GetMapping("/{id}/detail")
    public String selectOne(@PathVariable int id, Model model) {
        model.addAttribute("ioDTO", incomeService.selectOne(id));
        return "user/accounting/income/detail";
    }

    @Override
    @GetMapping("/register")
    public String registerForm() {
        return "user/accounting/income/register";
    }

    @Override
    @GetMapping("/{id}/update")
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("ioDTO", incomeService.selectOne(id));
        return "user/accounting/income/update";
    }
}
