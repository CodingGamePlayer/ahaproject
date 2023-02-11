package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.entity.LaborCost;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LaborCostMapper {
    @Insert("INSERT INTO labor_cost lc_id, emp_name, cp_name, cst_name, cp_name, lc_value, lc_date VALUES #{laborCost.lc_id}, #{laborCost.emp_name}, #{laborCost.cp_name}, #{laborCost.cst_name}, #{laborCost.lc_value}, #{laborCost.lc_date}")
    int register(@Param("laborCost") LaborCost laborCost);

    @Select("SELECT * FROM labor_cost ORDER BY lc_id DESC")
    @Results(id = "laborCostMap", value = {
            @Result(property = "lc_id", column = "lc_id"),
            @Result(property = "emp_name", column = "emp_name"),
            @Result(property = "cst_name", column = "cst_name"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "lc_value", column = "lc_value"),
            @Result(property = "lc_date", column = "lc_date")})
    List<LaborCost> selectAll();

    @Select("SELECT * FROM labor_cost WHERE lc_id = #{laborCost.lc_id}")
    @ResultMap("laborCostMap")
    LaborCost findById(@Param("laborCost") LaborCost laborCost);

    @Update("UPDATE lobor_cost SET emp_name = #{emp_name}, cp_name = #{cp_name}, cst_name = #{cst_name}, lc_value = #{lc_value}, lc_date = #{lc_date}")
    int update(@Param("laborCost") LaborCost laborCost);

    @Delete("DELETE FROM labor_cost WHERE lc_id = #{laborCost.lc_id}")
    int delete(@Param("laborCost") LaborCost laborCost);
}
