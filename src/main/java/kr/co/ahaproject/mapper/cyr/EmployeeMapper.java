package kr.co.ahaproject.mapper.cyr;

import kr.co.ahaproject.entity.Company;
import kr.co.ahaproject.entity.Employee;
import kr.co.ahaproject.entity.Misu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee order by emp_code desc")
    @Results(id = "EmployeeMap", value = {
            @Result(property = "emp_id", column = "emp_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "emp_code", column = "emp_code"),
            @Result(property = "emp_name", column = "emp_name"),
            @Result(property = "emp_joining", column = "emp_joining"),
            @Result(property = "emp_tel", column = "emp_tel"),
            @Result(property = "emp_email", column = "emp_email"),
            @Result(property = "emp_address", column = "emp_address"),
            @Result(property = "emp_account", column = "emp_account"),
            @Result(property = "emp_file", column = "emp_file"),
            @Result(property = "emp_etc1", column = "emp_etc1"),
            @Result(property = "emp_etc2", column = "emp_etc2"),
            @Result(property = "emp_etc3", column = "emp_etc3"),
    })
    List<Employee> listAll();

    @Select("select * from employee where emp_id = #{emp_id}")
    Employee selectOne(int emp_id);
    
    //id 선택하기
    @Select("select * from employee order by emp_id desc limit 1")
    Employee selectid();

    @Insert("insert into employee (cp_name,emp_code,emp_name,emp_joining,emp_regid,emp_tel,emp_email,emp_address,emp_account,emp_file,emp_etc1,emp_etc2,emp_etc3)" +
            " values (#{cp_name},#{emp_code},#{emp_name},#{emp_joining},#{emp_regid},#{emp_tel},#{emp_email},#{emp_address},#{emp_account},#{emp_file},#{emp_etc1},#{emp_etc2},#{emp_etc3})")
    int insert(Employee employee);

    @Update("update employee set emp_code=#{emp_code},emp_name=#{emp_name},emp_regid=#{emp_regid},emp_joining=#{emp_joining},emp_tel=#{emp_tel},emp_email=#{emp_email}," +
            "emp_address=#{emp_address},emp_account=#{emp_account},emp_file={emp_file},emp_etc1=#{emp_etc1},emp_etc2=#{emp_etc2},emp_etc3=#{emp_etc3}")
    int update(Employee employee);

    @Delete("delete from employee where emp_id=#{emp_id}")
    int delete(int emp_id);

}
