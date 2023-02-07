package kr.co.ahaproject.controller.kjh.imp;

import kr.co.ahaproject.controller.kjh.IncomeController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/accounting/income")
public class IncomeControllerImp implements IncomeController {
    @Override
    @GetMapping("/list")
    public String selectAll() {
        return "user/income/list";
    }

    @Override
    @GetMapping("/detail")
    public String selectOne() {
        return "user/income/detail";
    }

    @Override
    @GetMapping("/register")
    public String registerForm() {
        return "user/income/register";
    }

    @Override
    @GetMapping("/update")
    public String editForm() {
        return "user/income/update";
    }
}
