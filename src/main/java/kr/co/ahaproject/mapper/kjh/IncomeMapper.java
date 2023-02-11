package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.dto.IncomeOutcomeDTO;
import kr.co.ahaproject.entity.IncomeOutcome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IncomeMapper {
    @Select("SELECT `a`.`io_id`, `a`.`cp_name`, `a`.`io_date`, `a`.`io_content`, " +
            "`a`.`in_supp_value`, `a`.`in_total_value`, `a`.`in_collect_value`, `a`.`in_collect_remain`, " +
            "`b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` " +
            "FROM (SELECT `io_id`, `cp_name`, `cl_code`, `cst_code`, `io_date`, `io_content`, `in_supp_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `in_total_value`, " +
            "`in_collect_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) " +
            "- sum(`in_collect_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `in_collect_remain` " +
            "FROM `ahaproject`.`income_outcome` ORDER BY `cp_name`, `cl_code`, `cst_code`) AS `a` " +
            "LEFT OUTER JOIN `client` AS `b` " +
            "ON `a`.`cl_code` = `b`.`cl_code` " +
            "LEFT OUTER JOIN `construction` AS `c` " +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @Results(id = "ioMap", value = {
            @Result(property = "io_id", column = "io_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "io_date", column = "io_date"),
            @Result(property = "io_content", column = "io_content"),
            @Result(property = "in_supp_value", column = "in_supp_value"),
            @Result(property = "in_total_value", column = "in_total_value"),
            @Result(property = "in_collect_value", column = "in_collect_value"),
            @Result(property = "in_collect_remain", column = "in_collect_remain"),
    })
    List<IncomeOutcome> selectAll();

    @Select("SELECT `a`.`io_id`, `a`.`cp_name`, `a`.`io_date`, `a`.`io_content`, `a`.`in_supp_value`, `a`.`in_total_value`, " +
            "`a`.`in_collect_value`, `a`.`in_collect_remain`, `b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` " +
            "FROM (SELECT `io_id`, `cp_name`, `cl_code`, `cst_code`, `io_date`, `io_content`, `in_supp_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `in_total_value`, " +
            "`in_collect_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) " +
            "- sum(`in_collect_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `in_collect_remain` " +
            "FROM `ahaproject`.`income_outcome` WHERE `cl_code` = #{cl_code} ORDER BY `cp_name`, `cl_code`, `cst_code`) AS `a` " +
            "LEFT OUTER JOIN `client` AS `b` " +
            "ON `a`.`cl_code` = `b`.`cl_code` " +
            "LEFT OUTER JOIN `construction` AS `c` " +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @ResultMap("ioMap")
    List<IncomeOutcome> findByClcode(String cl_code);

    @Select("SELECT * FROM ahaproject.income_outcome " +
            "WHERE io_id = #{io_id}")
    @ResultMap("ioMap")
    IncomeOutcome selectOne(long io_id);

    @Insert("insert into ahaproject.income_outcome (cl_code, cst_code, cp_name, io_date, io_content, in_supp_value, in_total_value, in_collect_value, in_collect_remain) " +
            "values(#{io.cl_code}, #{io.cst_code}, #{io.cp_name}, #{io.io_date}, #{io.io_content}, " +
            "#{io.in_supp_value}, #{io.in_total_value}, #{io.in_collect_value}, #{io.in_collect_remain})")
    @Options(useGeneratedKeys = true, keyProperty = "io_id")
    int insert(@Param("io") IncomeOutcome io);

    @Update("update ahaproject.income_outcome " +
            "set cl_code = #{io.cl_code}," +
            "cst_code = #{io.cst_code}," +
            "cp_name = #{io.cp_name}," +
            "io_date = #{io.io_date}," +
            "io_content = #{io.io_content}," +
            "in_supp_value = #{io.in_supp_value}," +
            "in_collect_value = #{io.in_collect_value},")
    int update(@Param("io") IncomeOutcome io);

    @Delete("delete from ahaproject.income_outcome where io_id = #{io.io_id}")
    int delete(@Param("io") IncomeOutcome io);
}