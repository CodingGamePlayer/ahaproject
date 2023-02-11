package kr.co.ahaproject.controller.cyr;

import kr.co.ahaproject.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface EmployeeController {
    //리스트 페이지로 이동
    String listAll(Model model);

    //선택보기 페이지 이동
    String selectOne(Model model);

    String goInsert(Model model);

    ResponseEntity delete(Employee employee);

    void emEditForm(Employee employee, Model model);

    ResponseEntity register(Employee employee);

    ResponseEntity update(Employee employee);

}
