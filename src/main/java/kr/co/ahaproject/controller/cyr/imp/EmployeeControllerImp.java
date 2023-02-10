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
import org.springframework.web.bind.annotation.*;


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
        int id = employeeService.selectid() +1;
        String idkey = String.format("%04d",id);
        model.addAttribute("idkey",idkey);
        return "user/employee/emform";
    }

    @Override
    @DeleteMapping("user/employee/delete")
    public ResponseEntity<Employee> delete(@RequestBody Employee employee) {
        int id = employee.getEmp_id().intValue();
        int result = employeeService.delete(id);
        if (result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Override
    @GetMapping("user/employee/emeditform")
    public String emEditForm(Employee employee, Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());
        int id = employee.getEmp_id().intValue();
        model.addAttribute("eDTO",employeeService.selectOne(id));

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
    @PutMapping("user/employee/emeditform")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {

        int result = employeeService.update(employee);
//        log.info(String.valueOf(result));
        if (result == 1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}