package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.entity.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> listAll();
    Employee selectOne(int emp_id);
    int insert(Employee employee);
    int update(Employee employee);
    int delete(int emp_id);
}
