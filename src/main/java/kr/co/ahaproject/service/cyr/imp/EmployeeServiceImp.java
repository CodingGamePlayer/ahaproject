package kr.co.ahaproject.service.cyr.imp;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.EmployeeDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.mapper.cyr.EmployeeMapper;
import kr.co.ahaproject.service.cyr.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    private ModelMapper modelMapper = new ModelMapper();

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
    public int insert(EmployeeDTO employeeDTO) {

        employeeDTO.setEmp_use(true);
        return employeeMapper.insert(modelMapper.map(employeeDTO, Employee.class));
    }

    @Override
    public int update(Employee employee) {
        return employeeMapper.update(employee);
    }

    @Override
    public int delete(int emp_id) {
        return employeeMapper.delete(emp_id);
    }

    @Override
    public int count() {
        return employeeMapper.count();
    }

    @Override
    public PageResponseDTO<EmployeeDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {
        List<EmployeeDTO> employeeDTOList = employeeMapper.selectAllForPaging(pageRequestDTO)
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());

        int count = employeeMapper.getCount(pageRequestDTO);

        PageResponseDTO<EmployeeDTO> pageResponseDTO = PageResponseDTO.<EmployeeDTO>withAll()
                .total(count)
                .dtoList(employeeDTOList)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }
}
