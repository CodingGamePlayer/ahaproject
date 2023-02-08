package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Misu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MisuMapper {

    @Insert("INSERT INTO `ahaproject`.`misu` (`misu_div`, `cp_name`, `cst_code`, `misu_manager`, `misu_value`, " +
            "`misu_name`, `misu_total_value`, `misu_collect_date`, `misu_collect_value`, `misu_finished`,`misu_uuid`,`misu_filename`, `misu_etc`) " +
            "VALUES (#{misu.misu_div}, #{misu.cp_name}, #{misu.cst_code}, #{misu.misu_manager}, #{misu.misu_value}, #{misu.misu_name}, #{misu.misu_total_value}," +
            " #{misu.misu_collect_date}, #{misu.misu_collect_value}, #{misu.misu_finished}, #{misu.misu_uuid}, #{misu.misu_filename}, #{misu.misu_etc})")
    int register(@Param("misu")Misu misu);


    @Select("SELECT * FROM misu")
    @Results(id = "misuMap", value = {
            @Result(property = "misu_id", column = "misu_id"),
            @Result(property = "misu_div", column = "misu_div"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "misu_manager", column = "misu_manager"),
            @Result(property = "misu_value", column = "misu_value"),
            @Result(property = "misu_name", column = "misu_name"),
            @Result(property = "misu_total_value", column = "misu_total_value"),
            @Result(property = "misu_collect_date", column = "misu_collect_date"),
            @Result(property = "misu_collect_value", column = "misu_collect_value"),
            @Result(property = "misu_finished", column = "misu_finished"),
            @Result(property = "misu_uuid", column = "misu_uuid"),
            @Result(property = "misu_filename", column = "misu_filename"),
            @Result(property = "misu_etc", column = "misu_etc")})
    List<Misu> selectAll();

    @Select("SELECT * FROM misu WHERE misu_id = #{misu.misu_id}")
    @ResultMap("misuMap")
    Misu findById(@Param("misu") Misu misu);

    @Update("UPDATE `ahaproject`.`misu` SET " +
            "`misu_div` = #{misu.misu_div}, `cp_name` = #{misu.cp_name}, `cst_code` = #{misu.cst_code}, " +
            "`misu_manager` = #{misu.misu_manager}, `misu_value` = #{misu.misu_value}, `misu_name` = #{misu.misu_name}, " +
            "`misu_total_value` = #{misu.misu_total_value}, `misu_collect_date` = #{misu.misu_collect_date}, `misu_collect_value` = #{misu.misu_collect_value}, " +
            "`misu_finished` = #{misu.misu_finished}, `misu_uuid` = #{misu.misu_uuid}, `misu_filename` = #{misu.misu_filename}, " +
            "`misu_etc` = #{misu.misu_etc} WHERE (`misu_id` = #{misu.misu_id})")
    int update(@Param("misu") Misu misu);
}
