package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.dto.LaborCostListDTO;
import kr.co.ahaproject.entity.LaborCost;
import kr.co.ahaproject.entity.MachRent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LaborCostMapper {
    @Insert("INSERT INTO labor_cost(emp_code, cst_code, cl_code, lc_value, lc_date, lc_regit)" +
            "VALUES (#{laborCost.emp_code}, #{laborCost.cst_code}, #{laborCost.cl_code}, #{laborCost.lc_value}, #{laborCost.lc_date}, #{laborCost.lc_regit})")
        int register(@Param("laborCost") LaborCost laborCost);

    @Select("SELECT * FROM labor_cost ORDER BY lc_id DESC")
    @Results(id = "laborCostMap", value = {
            @Result(property = "lc_id", column = "lc_id"),
            @Result(property = "emp_code", column = "emp_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "lc_value", column = "lc_value"),
            @Result(property = "lc_date", column = "lc_date"),
            @Result(property = "lc_regit", column = "lc_regit")
    })
    List<LaborCost> selectAll();

    @Select("SELECT * FROM labor_cost WHERE lc_id = #{laborCost.lc_id}")
    @ResultMap("laborCostMap")
    LaborCost findById(@Param("laborCost") LaborCost laborCost);

    @Update("UPDATE labor_cost SET " +
            "emp_code = #{laborCost.emp_code}, cst_code = #{laborCost.cst_code}, " +
            "cl_code = #{laborCost.cl_code}, lc_value = #{laborCost.lc_value}, " +
            "lc_date = #{laborCost.lc_date}, lc_regit = #{laborCost.lc_regit} " +
            "WHERE lc_id = #{laborCost.lc_id}")
    int update(@Param("laborCost") LaborCost laborCost);

    @Delete("DELETE FROM labor_cost WHERE lc_id = #{laborCost.lc_id}")
    int delete(@Param("laborCost")LaborCost laborCost);

    @Select("SELECT A.lc_id, B.emp_name, C.cst_name, D.cp_name, A.lc_value, A.lc_date, A.lc_regit " +
            "FROM labor_cost A JOIN employee B ON A.emp_code = B.emp_code " +
            "JOIN construction C ON A.cst_code = C.cst_code " +
            "JOIN client D on A.cl_code = D.cl_code ORDER BY A.lc_id DESC")
    List<LaborCostListDTO> selectAllName();
}
