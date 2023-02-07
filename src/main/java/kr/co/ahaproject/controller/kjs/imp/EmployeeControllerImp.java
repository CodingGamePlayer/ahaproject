package kr.co.ahaproject.controller.kjs.imp;

import kr.co.ahaproject.controller.kjs.EmployeeController;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.kjs.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeControllerImp implements EmployeeController {


    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("user/employee/emmain")
    public String listAll(Model model) {
        model.addAttribute("list",employeeService.listAll());
        return "user/employee/emmain";
    }
    @Override
    public String selectOne(Model model) {

        return null;
    }

    @Override
    @GetMapping("user/employee/emform")
    public String goInsert(Model model) {
    model.addAttribute("companyDTOs",companyService.selectAll());
        return "user/employee/emform";
    }

    @Override
//    @PostMapping("user/employee/em-form")
    public String insert() {
//
        return "user/employee/emmain";
    }

    @Override
    public String goUpdate(Model model) {
        return null;
    }

    @Override
    public String Insert() {
        return null;
    }

    @Override
    public String Delete() {
        return null;
    }
}