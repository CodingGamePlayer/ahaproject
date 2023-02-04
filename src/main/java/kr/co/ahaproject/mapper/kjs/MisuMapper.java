package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Misu;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MisuMapper {

    @Insert("INSERT INTO `ahaproject`.`misu` (`misu_div`, `cp_name`, `cst_code`, `misu_manager`, `misu_value`, " +
            "`misu_name`, `misu_total_value`, `misu_collect_date`, `misu_collect_value`, `misu_finished`, `misu_etc`) " +
            "VALUES (#{misu.misu_div}, #{misu.cp_name}, #{misu.cst_code}, #{misu.misu_manager}, #{misu.misu_value}, #{misu.misu_name}, #{misu.misu_total_value}," +
            " #{misu.misu_collect_date}, #{misu.misu_collect_value}, #{misu.misu_finished}, #{misu.misu_etc})")
    int register(@Param("misu")Misu misu);


//    @Results(id = "misuMap", value = {
//            @Result(property = "misu_div", column = "misu_div"),
//            @Result(property = "cp_name", column = "cp_name"),
//            @Result(property = "cst_code", column = "cst_code"),
//            @Result(property = "misu_manager", column = "misu_manager"),
//            @Result(property = "misu_value", column = "misu_value"),
//            @Result(property = "misu_name", column = "misu_name"),
//            @Result(property = "misu_total_value", column = "misu_total_value"),
//            @Result(property = "misu_collect_date", column = "misu_collect_date"),
//            @Result(property = "misu_collect_value", column = "misu_collect_value"),
//            @Result(property = "misu_finished", column = "misu_finished"),
//            @Result(property = "misu_etc", column = "misu_etc")
//    })
}
