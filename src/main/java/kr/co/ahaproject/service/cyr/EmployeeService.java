package kr.co.ahaproject.service.cyr;

import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> listAll();
    Employee selectOne(int emp_id);
    int selectid();
    int insert(Employee employee);
    int update(Employee employee);
    int delete(int emp_id);


}
