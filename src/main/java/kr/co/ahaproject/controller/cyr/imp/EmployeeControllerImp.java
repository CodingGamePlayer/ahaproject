package kr.co.ahaproject.controller.cyr.imp;

import kr.co.ahaproject.controller.cyr.EmployeeController;
import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.cyr.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class EmployeeControllerImp implements EmployeeController {


    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("user/employee/emmain")
    public String listAll(Model model) {
        model.addAttribute("list", employeeService.listAll());
        return "user/employee/emmain";
    }

    @Override
    public String selectOne(Model model) {

        return null;
    }

    @Override
    @GetMapping("user/employee/emform")
    public String goInsert(Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());
        return "user/employee/emform";
    }


    @Override
    @GetMapping("user/employee/emeditform")
    public String emEditForm(Employee employee, Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());


        return "user/employee/emeditform";
    }


    @Override
    @PostMapping("user/employee/emform")
    public ResponseEntity<Employee> register(@RequestBody Employee employee) {

        if(employee == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        int result = employeeService.insert(employee);


        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("employee/emeditform")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {

        int result = employeeService.update(employee);
//        log.info(String.valueOf(result));
        if (result == 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}