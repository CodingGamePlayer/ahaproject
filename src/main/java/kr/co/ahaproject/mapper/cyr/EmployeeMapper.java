package kr.co.ahaproject.mapper.cyr;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee order by emp_code desc")
    @Results(id = "employeeMap", value = {
            @Result(property = "emp_id", column = "emp_id"),
            @Result(property = "cp_id", column = "cp_id"),
            @Result(property = "emp_code", column = "emp_code"),
            @Result(property = "emp_name", column = "emp_name"),
            @Result(property = "emp_joining", column = "emp_joining"),
            @Result(property = "emp_tel", column = "emp_tel"),
            @Result(property = "emp_email", column = "emp_email"),
            @Result(property = "emp_address", column = "emp_address"),
            @Result(property = "emp_account", column = "emp_account"),
            @Result(property = "emp_uuid", column = "emp_uuid"),
            @Result(property = "emp_filename", column = "emp_filename"),
            @Result(property = "emp_etc1", column = "emp_etc1"),
            @Result(property = "emp_etc2", column = "emp_etc2"),
            @Result(property = "emp_etc3", column = "emp_etc3"),
            @Result(property = "emp_use", column = "emp_use")
    })
    List<Employee> listAll();

    @Select("select * from employee where emp_id = #{emp_id}")
    Employee selectOne(int emp_id);
    
    //id 선택하기
    @Select("select emp_id from employee order by emp_id desc limit 1")
    int selectid();

    @Select("select count(*) from employee")
    int count();

    @Insert("insert into employee (cp_id,emp_code,emp_name,emp_joining,emp_regid,emp_tel,emp_email,emp_address,emp_account,emp_uuid,emp_filename,emp_etc1,emp_etc2,emp_etc3, emp_use)" +
            " values (#{cp_id},#{emp_code},#{emp_name},#{emp_joining},#{emp_regid},#{emp_tel},#{emp_email},#{emp_address},#{emp_account},#{emp_uuid},#{emp_filename},#{emp_etc1},#{emp_etc2},#{emp_etc3},${emp_use})")
    int insert(Employee employee);

    @Update("update employee set cp_id=#{cp_id},emp_code=#{emp_code},emp_name=#{emp_name},emp_regid=#{emp_regid},emp_joining=#{emp_joining},emp_tel=#{emp_tel},emp_email=#{emp_email}," +
            "emp_address=#{emp_address},emp_account=#{emp_account},emp_uuid=#{emp_uuid},emp_filename=#{emp_filename},emp_etc1=#{emp_etc1},emp_etc2=#{emp_etc2},emp_etc3=#{emp_etc3},emp_use=#{emp_use} where emp_id=#{emp_id}")
    int update(Employee employee);

    @Delete("delete from employee where emp_id=#{emp_id}")
    int delete(int emp_id);

    List<Employee> selectAllForPaging(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

}
