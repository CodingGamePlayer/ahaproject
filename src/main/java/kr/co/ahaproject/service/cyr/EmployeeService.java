package kr.co.ahaproject.service.cyr;

import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Employee;

import java.util.List;
public interface EmployeeService {

    List<Employee> listAll();
    Employee selectOne(int emp_id);
    int selectid();
    int insert(EmployeeDTO employeeDTO);
    int update(Employee employee);
    int delete(int emp_id);
    int count();

    PageResponseDTO<EmployeeDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

}
