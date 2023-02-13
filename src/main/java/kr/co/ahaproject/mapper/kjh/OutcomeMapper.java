package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.entity.Outcome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OutcomeMapper {

    @Select("SELECT `a`.`out_id`, `a`.`cp_name`, `a`.`out_date`, `a`.`out_content`, `a`.`out_supp_value`, `a`.`out_total_value`, \n" +
            "`a`.`out_collect_value`, `a`.`out_collect_remain`, `b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` \n" +
            "FROM (SELECT `out_id`, `cp_name`, `cl_code`, `cst_code`, `out_date`, `out_content`, `out_supp_value`, \n" +
            "sum(`out_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `out_id`) AS `out_total_value` \n" +
            ", `out_collect_value`, \n" +
            "sum(`out_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `out_id`) \n" +
            "- sum(`out_collect_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `out_id`) AS `out_collect_remain` \n" +
            "FROM `ahaproject`.`outcome` ORDER BY `cp_name`, `cl_code`, `cst_code`) AS `a` \n" +
            "LEFT OUTER JOIN `client` AS `b` \n" +
            "ON `a`.`cl_code` = `b`.`cl_code` \n" +
            "LEFT OUTER JOIN `construction` AS `c` \n" +
            "ON `a`.`cst_code` = `c`.`cst_code`;")
    @Results(id = "outMap", value = {
            @Result(property = "out_id", column = "out_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "out_date", column = "out_date"),
            @Result(property = "out_content", column = "out_content"),
            @Result(property = "out_supp_value", column = "out_supp_value"),
            @Result(property = "out_total_value", column = "out_total_value"),
            @Result(property = "out_collect_value", column = "out_collect_value"),
            @Result(property = "out_collect_remain", column = "out_collect_remain"),
    })
    List<Outcome> selectAll();

    @Select("SELECT `a`.`out_id`, `a`.`cp_name`, `a`.`out_date`, `a`.`out_content`, `a`.`out_supp_value`, `a`.`out_total_value`, \n" +
            "`a`.`out_collect_value`, `a`.`out_collect_remain`, `b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` \n" +
            "FROM (SELECT `out_id`, `cp_name`, `cl_code`, `cst_code`, `out_date`, `out_content`, `out_supp_value`, `out_total_value` \n" +
            ", `out_collect_value`, `out_collect_remain` FROM `ahaproject`.`outcome` WHERE `out_id` = '2') AS `a` \n" +
            "LEFT OUTER JOIN `client` AS `b` \n" +
            "ON `a`.`cl_code` = `b`.`cl_code` \n" +
            "LEFT OUTER JOIN `construction` AS `c` \n" +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @ResultMap("outMap")
    Outcome selectOne(long out_id);

    @Insert("INSERT INTO `ahaproject`.`outcome` " +
            "(`cl_code`, `cst_code`, `cp_name`, `out_date`, `out_content`, `out_supp_value`, " +
            "`out_total_value`, `out_collect_value`, `out_collect_remain`) " +
            "VALUES (#{out.cl_code}, #{out.cst_code}, #{out.cp_name}, #{out.out_date}, #{out.out_content}, " +
            "#{out.out_supp_value}, #{out.out_total_value}, #{out.out_collect_value}, #{out.out_collect_remain})")
    @Options(useGeneratedKeys = true, keyProperty = "out_id")
    int insert(@Param("out") Outcome out);

    @Update("UPDATE `ahaproject`.`outcome` AS `a` \n" +
            "SET `a`.`cl_code` = (SELECT `b`.`cl_code` FROM `ahaproject`.`client` AS `b` \n" +
            "WHERE `b`.`cp_name` = #{out.cl_code}), \n" +
            "`a`.`cst_code` =  (SELECT `c`.`cst_code` FROM `ahaproject`.`construction` AS `c` \n" +
            "WHERE `c`.`cst_name` = #{out.cst_code}),\n" +
            "`a`.`cp_name` = #{out.cp_name},\n" +
            "`a`.`out_date` = #{out.out_date},\n" +
            "`a`.`out_content` = #{out.out_content},\n" +
            "`a`.`out_supp_value` = #{out.out_supp_value},\n" +
            "`a`.`out_collect_value` = #{out.out_collect_value} \n" +
            " WHERE `a`.`out_id` = #{out.out_id}\")")
    int update(@Param("out") Outcome out);

    @Delete("DELETE FROM `ahaproject`.`outcome` WHERE `out_id` = #{out.out_id}")
    int delete(@Param("out") Outcome out);
}
