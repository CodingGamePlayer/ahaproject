package kr.co.ahaproject.controller.cyr;

import kr.co.ahaproject.dto.EmployeeDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface EmployeeController {
    //리스트 페이지로 이동
    String employee(PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model);

    //선택보기 페이지 이동
    String selectOne(Model model);

    String goInsert(Model model);

    ResponseEntity delete(Employee employee);

    String emEditForm(Employee employee, Model model);

    ResponseEntity register(EmployeeDTO employeeDTO);

    ResponseEntity update(Employee employee);



}
