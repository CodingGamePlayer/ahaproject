package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.entity.IncomeOutcome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OutcomeMapper {

    @Select("SELECT `a`.`io_id`, `a`.`cp_name`, `a`.`io_date`, `a`.`io_content`, `a`.`out_supp_value`, `a`.`out_total_value`, \n" +
            "`a`.`out_collect_value`, `a`.`out_collect_remain`, `b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` \n" +
            "FROM (SELECT `io_id`, `cp_name`, `cl_code`, `cst_code`, `io_date`, `io_content`, `out_supp_value`, \n" +
            "sum(`out_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `out_total_value` \n" +
            ", `out_collect_value`, \n" +
            "sum(`out_supp_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) \n" +
            "- sum(`out_collect_value`) OVER(PARTITION BY `cst_code`, `cl_code`, `cp_name` ORDER BY `io_id`) AS `out_collect_remain` \n" +
            "FROM `ahaproject`.`income_outcome` ORDER BY `cp_name`, `cl_code`, `cst_code`) AS `a` \n" +
            "LEFT OUTER JOIN `client` AS `b` \n" +
            "ON `a`.`cl_code` = `b`.`cl_code` \n" +
            "LEFT OUTER JOIN `construction` AS `c` \n" +
            "ON `a`.`cst_code` = `c`.`cst_code`;")
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

    @Select("SELECT `a`.`io_id`, `a`.`cp_name`, `a`.`io_date`, `a`.`io_content`, `a`.`out_supp_value`, `a`.`out_total_value`, \n" +
            "`a`.`out_collect_value`, `a`.`out_collect_remain`, `b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` \n" +
            "FROM (SELECT `io_id`, `cp_name`, `cl_code`, `cst_code`, `io_date`, `io_content`, `out_supp_value`, `out_total_value` \n" +
            ", `out_collect_value`, `out_collect_remain` FROM `ahaproject`.`income_outcome` WHERE `io_id` = '2') AS `a` \n" +
            "LEFT OUTER JOIN `client` AS `b` \n" +
            "ON `a`.`cl_code` = `b`.`cl_code` \n" +
            "LEFT OUTER JOIN `construction` AS `c` \n" +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @ResultMap("ioMap")
    IncomeOutcome selectOne(long io_id);

    @Insert("INSERT INTO `ahaproject`.`income_outcome` " +
            "(`cl_code`, `cst_code`, `cp_name`, `io_date`, `io_content`, `out_supp_value`, " +
            "`out_total_value`, `out_collect_value`, `out_collect_remain`) " +
            "VALUES (#{io.cl_code}, #{io.cst_code}, #{io.cp_name}, #{io.io_date}, #{io.io_content}, " +
            "#{io.out_supp_value}, #{io.out_total_value}, #{io.out_collect_value}, #{io.out_collect_remain})")
    @Options(useGeneratedKeys = true, keyProperty = "io_id")
    int insert(@Param("io") IncomeOutcome io);

    @Update("UPDATE `ahaproject`.`income_outcome` AS `a` \n" +
            "SET `a`.`cl_code` = (SELECT `b`.`cl_code` FROM `ahaproject`.`client` AS `b` \n" +
            "WHERE `b`.`cp_name` = #{io.cl_code}), \n" +
            "`a`.`cst_code` =  (SELECT `c`.`cst_code` FROM `ahaproject`.`construction` AS `c` \n" +
            "WHERE `c`.`cst_name` = #{io.cst_code}),\n" +
            "`a`.`cp_name` = #{io.cp_name},\n" +
            "`a`.`io_date` = #{io.io_date},\n" +
            "`a`.`io_content` = #{io.io_content},\n" +
            "`a`.`out_supp_value` = #{io.out_supp_value},\n" +
            "`a`.`out_collect_value` = #{io.out_collect_value} \n" +
            " WHERE `a`.`io_id` = #{io.io_id}\")")
    int update(@Param("io") IncomeOutcome io);

    @Delete("DELETE FROM `ahaproject`.`income_outcome` WHERE `io_id` = #{io.io_id}")
    int delete(@Param("io") IncomeOutcome io);
}
