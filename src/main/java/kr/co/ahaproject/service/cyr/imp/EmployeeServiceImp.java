package kr.co.ahaproject.service.cyr.imp;

import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.mapper.cyr.EmployeeMapper;
import kr.co.ahaproject.service.cyr.EmployeeService;
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
    public int selectid(){
        return employeeMapper.selectid();
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
