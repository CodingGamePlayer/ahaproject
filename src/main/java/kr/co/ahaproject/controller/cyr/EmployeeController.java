package kr.co.ahaproject.controller.cyr;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeController {
    //리스트 페이지로 이동
    String listAll(Model model);

    //선택보기 페이지 이동
    String selectOne(Model model);

    String goInsert(Model model);

    String emEditForm(Employee employee, Model model);

    ResponseEntity register(Employee employee);

    ResponseEntity update(Employee employee);

}
