package kr.co.ahaproject.mapper.kjh;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SummaryMapper {

    @Select("SELECT \n" +
            "    `a`.`cp_name`,\n" +
            "    `b`.`cp_name` AS `cl_code`,\n" +
            "    `c`.`cst_name` AS `cst_code`,\n" +
            "    `a`.`out_supp_value`,\n" +
            "    `a`.`out_collect_value`,\n" +
            "    `a`.`out_collect_remain`,\n" +
            "    `a`.`in_supp_value`,\n" +
            "    `a`.`in_collect_value`,\n" +
            "    `a`.`in_collect_remain`\n" +
            "FROM\n" +
            "    (SELECT \n" +
            "        `cp_name`,\n" +
            "            `cl_code`,\n" +
            "            `cst_code`,\n" +
            "            SUM(`out_supp_value`) AS `out_supp_value`,\n" +
            "            SUM(`out_collect_value`) AS `out_collect_value`,\n" +
            "            SUM(`out_supp_value`) - SUM(`out_collect_value`) AS `out_collect_remain`,\n" +
            "            SUM(`in_supp_value`) AS `in_supp_value`,\n" +
            "            SUM(`in_collect_value`) AS `in_collect_value`,\n" +
            "            SUM(`in_supp_value`) - SUM(`in_collect_value`) AS `in_collect_remain`\n" +
            "    FROM\n" +
            "        (((SELECT \n" +
            "        `a`.`cp_name`,\n" +
            "            `a`.`cl_code`,\n" +
            "            `a`.`cst_code`,\n" +
            "            `b`.`out_supp_value`,\n" +
            "            `b`.`out_collect_value`,\n" +
            "            `b`.`out_collect_remain`,\n" +
            "            `a`.`in_supp_value`,\n" +
            "            `a`.`in_collect_value`,\n" +
            "            `a`.`in_collect_remain`\n" +
            "    FROM\n" +
            "        `ahaproject`.`income` AS `a`\n" +
            "    LEFT JOIN `ahaproject`.`outcome` AS `b` ON (`a`.`cp_name` = `b`.`cp_name`\n" +
            "        AND `a`.`cl_code` = `b`.`cl_code`\n" +
            "        AND `a`.`cst_code` = `b`.`cst_code`)\n" +
            "    WHERE\n" +
            "        `b`.`cp_name` IS NULL) UNION (SELECT \n" +
            "        `b`.`cp_name`,\n" +
            "            `b`.`cl_code`,\n" +
            "            `b`.`cst_code`,\n" +
            "            `b`.`out_supp_value`,\n" +
            "            `b`.`out_collect_value`,\n" +
            "            `b`.`out_collect_remain`,\n" +
            "            `a`.`in_supp_value`,\n" +
            "            `a`.`in_collect_value`,\n" +
            "            `a`.`in_collect_remain`\n" +
            "    FROM\n" +
            "        `ahaproject`.`income` AS `a`\n" +
            "    RIGHT JOIN `ahaproject`.`outcome` AS `b` ON (`a`.`cp_name` = `b`.`cp_name`\n" +
            "        AND `a`.`cl_code` = `b`.`cl_code`\n" +
            "        AND `a`.`cst_code` = `b`.`cst_code`)\n" +
            "    WHERE\n" +
            "        `a`.`cp_name` IS NULL)) UNION (SELECT \n" +
            "        `a`.`cp_name`,\n" +
            "            `a`.`cl_code`,\n" +
            "            `a`.`cst_code`,\n" +
            "            `b`.`out_supp_value`,\n" +
            "            `b`.`out_collect_value`,\n" +
            "            `b`.`out_collect_remain`,\n" +
            "            `a`.`in_supp_value`,\n" +
            "            `a`.`in_collect_value`,\n" +
            "            `a`.`in_collect_remain`\n" +
            "    FROM\n" +
            "        (SELECT \n" +
            "        `cp_name`,\n" +
            "            `cl_code`,\n" +
            "            `cst_code`,\n" +
            "            SUM(`in_supp_value`) AS `in_supp_value`,\n" +
            "            SUM(`in_collect_value`) AS `in_collect_value`,\n" +
            "            SUM(`in_supp_value`) - SUM(`in_collect_value`) AS `in_collect_remain`\n" +
            "    FROM\n" +
            "        `ahaproject`.`income`\n" +
            "    GROUP BY `cp_name` , `cl_code` , `cst_code` WITH ROLLUP) AS `a`\n" +
            "    JOIN (SELECT \n" +
            "        `cp_name`,\n" +
            "            `cl_code`,\n" +
            "            `cst_code`,\n" +
            "            SUM(`out_supp_value`) AS `out_supp_value`,\n" +
            "            SUM(`out_collect_value`) AS `out_collect_value`,\n" +
            "            SUM(`out_supp_value`) - SUM(`out_collect_value`) AS `out_collect_remain`\n" +
            "    FROM\n" +
            "        `ahaproject`.`outcome`\n" +
            "    GROUP BY `cp_name` , `cl_code` , `cst_code` WITH ROLLUP) AS `b` ON (`a`.`cp_name` = `b`.`cp_name`\n" +
            "        AND `a`.`cl_code` = `b`.`cl_code`\n" +
            "        AND `a`.`cst_code` = `b`.`cst_code`))) AS `d`\n" +
            "    GROUP BY `cp_name` , `cl_code` , `cst_code` WITH ROLLUP) AS `a`\n" +
            "        LEFT OUTER JOIN\n" +
            "    `ahaproject`.`client` AS `b` ON `a`.`cl_code` = `b`.`cl_code`\n" +
            "        LEFT OUTER JOIN\n" +
            "    `ahaproject`.`construction` AS `c` ON `a`.`cst_code` = `c`.`cst_code`;")

    @Results(id = "ioMap", value = {
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "out_supp_value", column = "out_supp_value"),
            @Result(property = "out_collect_value", column = "out_collect_value"),
            @Result(property = "out_collect_remain", column = "out_collect_remain"),
            @Result(property = "in_supp_value", column = "in_supp_value"),
            @Result(property = "in_collect_value", column = "in_collect_value"),
            @Result(property = "in_collect_remain", column = "in_collect_remain"),
    })
    List<Summary> selectAll();

    List<Summary> selectAllForPaging(PageRequestDTO pageRequestDTO);

}
