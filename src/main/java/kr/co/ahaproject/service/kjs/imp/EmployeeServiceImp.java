package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.mapper.kjs.EmployeeMapper;
import kr.co.ahaproject.service.kjs.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @Override
    public Employee selectOne(int emp_id) {
        return employeeMapper.selectOne(emp_id);
    }

    @Override
    public int insert(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int delete(int emp_id) {
        return employeeMapper.delete(emp_id);
    }
}
