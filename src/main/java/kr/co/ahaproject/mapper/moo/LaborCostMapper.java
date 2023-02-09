package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.entity.LaborCost;
import kr.co.ahaproject.entity.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LaborCostMapper {

    @Select("SELECT * FROM labor_cost ORDER BY lc_id DESC")
    @Results(id = "labor_costMap", value = {
            @Result(property = "lc_id", column = "lc_id"),
            @Result(property = "emp_code", column = "emp_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "lc_value", column = "lc_value"),
            @Result(property = "lc_date", column = "lc_date"),
            @Result(property = "lc_regit", column = "lc_regit")})
    List<LaborCost> selectAll();
}
