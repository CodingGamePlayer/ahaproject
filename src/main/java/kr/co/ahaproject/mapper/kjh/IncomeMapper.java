package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.entity.Income;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IncomeMapper {
    @Select("SELECT `a`.`in_id`, `a`.`cp_name`, `a`.`in_date`, `a`.`in_content`, " +
            "`a`.`in_supp_value`, `a`.`in_total_value`, `a`.`in_collect_value`, `a`.`in_collect_remain`, " +
            "`b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` " +
            "FROM (SELECT `in_id`, `cp_name`, `cl_code`, `cst_code`, `in_date`, `in_content`, `in_supp_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `in_id`) " +
            "AS `in_total_value`, " +
            "`in_collect_value`, " +
            "sum(`in_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `in_id`) " +
            "- sum(`in_collect_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `in_id`) " +
            "AS `in_collect_remain` " +
            "FROM `ahaproject`.`income` ORDER BY `cp_name`, `cl_code`, `cst_code`) AS `a` " +
            "LEFT OUTER JOIN `client` AS `b` " +
            "ON `a`.`cl_code` = `b`.`cl_code` " +
            "LEFT OUTER JOIN `construction` AS `c` " +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @Results(id = "inMap", value = {
            @Result(property = "in_id", column = "in_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "in_date", column = "in_date"),
            @Result(property = "in_content", column = "in_content"),
            @Result(property = "in_supp_value", column = "in_supp_value"),
            @Result(property = "in_total_value", column = "in_total_value"),
            @Result(property = "in_collect_value", column = "in_collect_value"),
            @Result(property = "in_collect_remain", column = "in_collect_remain"),
    })
    List<Income> selectAll();

    @Select("SELECT `a`.`in_id`, `a`.`cp_name`, `a`.`in_date`, `a`.`in_content`, `a`.`in_supp_value`, " +
            "`a`.`in_total_value`, `a`.`in_collect_value`, `a`.`in_collect_remain`, " +
            "`b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` " +
            "FROM (SELECT `in_id`, `cp_name`, `cl_code`, `cst_code`, `in_date`, `in_content`, `in_supp_value`, " +
            "`in_total_value`, `in_collect_value`, `in_collect_remain` " +
            "FROM `ahaproject`.`income` WHERE `in_id` = #{in_id}) AS `a` " +
            "LEFT OUTER JOIN `client` AS `b` " +
            "ON `a`.`cl_code` = `b`.`cl_code` " +
            "LEFT OUTER JOIN `construction` AS `c` " +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @ResultMap("inMap")
    Income selectOne(long in_id);

    @Insert("INSERT INTO `ahaproject`.`income` " +
            "(`cl_code`, `cst_code`, `cp_name`, `in_date`, `in_content`, `in_supp_value`, " +
            "`in_total_value`, `in_collect_value`, `in_collect_remain`) " +
            "VALUES (#{in.cl_code}, #{in.cst_code}, #{in.cp_name}, #{in.in_date}, #{in.in_content}, " +
            "#{in.in_supp_value}, #{in.in_total_value}, #{in.in_collect_value}, #{in.in_collect_remain})")
    @Options(useGeneratedKeys = true, keyProperty = "in_id")
    int insert(@Param("in") Income in);

    @Update("UPDATE `ahaproject`.`income` AS `a` "+
            "SET `a`.`cl_code` = (SELECT `b`.`cl_code` FROM `ahaproject`.`client` AS `b` " +
            "WHERE `b`.`cp_name` = #{in.cl_code}), "+
            "`a`.`cst_code` =  (SELECT `c`.`cst_code` FROM `ahaproject`.`construction` AS `c` " +
            "WHERE `c`.`cst_name` = #{in.cst_code}), "+
            "`a`.`cp_name` = #{in.cp_name}," +
            "`a`.`in_date` = #{in.in_date}," +
            "`a`.`in_content` = #{in.in_content}," +
            "`a`.`in_supp_value` = #{in.in_supp_value}," +
            "`a`.`in_collect_value` = #{in.in_collect_value} " +
            " WHERE `a`.`in_id` = #{in.in_id}")
    int update(@Param("in") Income in);

    @Delete("DELETE FROM `ahaproject`.`income` WHERE `in_id` = #{in.in_id}")
    int delete(@Param("in") Income in);
}