package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IncomeMapper {
    @Select("select * from ahaproject.income_outcome")
    @Results(id = "ioMap", value = {
            @Result(property = "io_id", column = "io_id"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "in_supp_value", column = "in_supp_value"),
            @Result(property = "in_total_value", column = "in_total_value"),
            @Result(property = "in_collect_value", column = "in_collect_value"),
            @Result(property = "in_collect_remain", column = "in_collect_remain"),
    })
    List<IncomeOutcome> selectAll();

    @Select("select * from ahaproject.income_outcome where io_id = #{io_id}")
    @ResultMap("ioMap")
    IncomeOutcome selectOne(long io_id);

    @Insert("insert into ahaproject.income_outcome (cl_code, cst_code, cp_name, in_supp_value, in_total_value, in_collect_value, in_collect_remain) " +
            "values(#{io.cl_code}, #{io.cst_code}, #{io.cp_name}, #{io.in_supp_value}, #{io.in_total_value}, #{io.in_collect_value}, #{io.in_collect_remain})")
    @Options(useGeneratedKeys = true, keyProperty = "io_id")
    int insert(@Param("io") IncomeOutcome io);

    @Update("update ahaproject.income_outcome " +
            "set cl_code = #{io.cl_code}," +
            "cst_code = #{io.cst_code}," +
            "cp_name = #{io.cp_name}," +
            "in_supp_value = #{io.in_supp_value}," +
            "in_total_value = #{io.in_total_value}," +
            "in_collect_value = #{io.in_collect_value}," +
            "in_collect_remain = #{io.in_collect_remain}")
    int update(@Param("io") IncomeOutcome io);

    @Delete("delete from ahaproject.income_outcome where io_id = #{io.io_id}")
    int delete(@Param("io") IncomeOutcome io);
}