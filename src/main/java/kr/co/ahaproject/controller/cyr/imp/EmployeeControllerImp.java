package kr.co.ahaproject.controller.cyr.imp;

import kr.co.ahaproject.controller.cyr.EmployeeController;
import kr.co.ahaproject.dto.EmployeeDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.service.kjs.CompanyService;
import kr.co.ahaproject.service.cyr.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeeControllerImp implements EmployeeController {


    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    @GetMapping("user/employee/list")
    public String employee(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        PageResponseDTO<EmployeeDTO> pageResponseDTO = employeeService.selectAllForPaging(pageRequestDTO);


        model.addAttribute("employees", pageResponseDTO);
        return "/user/employee/employee";
    }

    @Override
    public String selectOne(Model model) {

        return null;
    }
    @Override
    @GetMapping("user/employee/emform")
    public String goInsert(Model model) {
        model.addAttribute("companyDTOs", companyService.selectAll());

        int count = employeeService.count();
        if(count>0){
        int id = employeeService.selectid() +1;
        String idkey = String.format("%04d",id);
            model.addAttribute("idkey",idkey);
       } else {
            String idkey = "0001";
            model.addAttribute("idkey",idkey);
            }
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
        model.addAttribute("eDTO",employeeService.selectOne(employee.getEmp_id().intValue()));

        return "user/employee/emeditform";
    }



    @Override
    @PostMapping("user/employee/emform")
    public ResponseEntity<Employee> register(@RequestBody EmployeeDTO employeeDTO) {

        if(employeeDTO == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


        int result = employeeService.insert(employeeDTO);


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
        if (result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}