package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.entity.Outcome;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SummaryMapper {

    @Select("SELECT `a`.`cp_name`, `a`.`out_supp_value`,  `a`.`out_collect_value`, `a`.`out_collect_remain`, " +
            "`a`.`in_supp_value`,  `a`.`in_collect_value`, `a`.`in_collect_remain`, " +
            "`b`.`cp_name` AS `cl_code`, `c`.`cst_name` AS `cst_code` " +
            "FROM (SELECT  `cp_name`, `cl_code`, `cst_code`, " +
            "sum(`out_supp_value`) AS `out_supp_value`, " +
            "sum(`out_collect_value`) AS `out_collect_value`, " +
            "sum(`out_supp_value`) - sum(`out_collect_value`) AS `out_collect_remain`, " +
            "sum(`in_supp_value`) AS `in_supp_value`, " +
            "sum(`in_collect_value`) AS `in_collect_value`, " +
            "sum(`in_supp_value`) - sum(`in_collect_value`) AS `in_collect_remain` " +
            "FROM `ahaproject`.`income_outcome` GROUP BY `cp_name`, `cl_code`, `cst_code` WITH ROLLUP) AS `a` " +
            "LEFT OUTER JOIN `client` AS `b` " +
            "ON `a`.`cl_code` = `b`.`cl_code` " +
            "LEFT OUTER JOIN `construction` AS `c` " +
            "ON `a`.`cst_code` = `c`.`cst_code`")
    @Results(id = "ioMap", value = {
            @Result(property = "io_id", column = "io_id"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "io_date", column = "io_date"),
            @Result(property = "io_content", column = "io_content"),
            @Result(property = "in_supp_value", column = "in_supp_value"),
            @Result(property = "in_total_value", column = "in_total_value"),
            @Result(property = "in_collect_value", column = "in_collect_value"),
            @Result(property = "in_collect_remain", column = "in_collect_remain"),
    })
    List<Outcome> selectAll();
}
