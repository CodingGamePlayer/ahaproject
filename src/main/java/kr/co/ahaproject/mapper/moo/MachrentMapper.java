package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.entity.MachRent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MachrentMapper {

    @Insert("INSERT INTO `ahaproject`.`mach_rent` (`cst_name`,`rent_start`, `rent_end`, `rent_bill_date`, `m_name`,`rent_supp_value`,`rent_tax`,`rent_collect_date`,`rent_collect_value`,`rent_misu`,`rent_etc`, `rent_regit`)" +
    "VALUES (#{machRent.cst_name}, #{machRent.rent_start}, #{machRent.rent_end}, #{machRent.rent_bill_date}, #{machRent.m_name}, #{machRent.rent_supp_value}, #{machRent.rent_tax}, #{machRent.rent_collect_date}, #{machRent.rent_collect_value}, #{machRent.rent_misu}, #{machRent.rent_etc}, #{machRent.rent_regit})")
    int register(@Param("machRent") MachRent machRent);

    @Select("SELECT * FROM mach_rent ORDER BY rent_id DESC")
    @Results(id = "machRentMap", value = {
            @Result(property = "cst_name", column = "cst_name"),
            @Result(property = "rent_start", column = "rent_start"),
            @Result(property = "rent_end", column = "rent_end"),
            @Result(property = "rent_bill_date", column = "rent_bill_date"),
            @Result(property = "m_name", column = "m_name"),
            @Result(property = "rent_supp_value", column = "rent_supp_value"),
            @Result(property = "rent_tax", column = "rent_tax"),
            @Result(property = "rent_collect_date", column = "rent_collect_date"),
            @Result(property = "rent_collect_value", column = "rent_collect_value"),
            @Result(property = "rent_misu", column = "rent_misu"),
            @Result(property = "rent_etc", column = "rent_etc"),
            @Result(property = "rent_regit", column = "rent_regit")
    })
    List<MachRent> selectAll();

    @Select("SELECT * FROM `ahaproject`.`mach_rent` WHERE rent_id = #{machRent.rent_id}")
    @ResultMap("machRentMap")
    MachRent findById(@Param("machRent") MachRent machRent);

    @Update("UPDATE `ahaproject`.`mach_rent` SET " +
            "`cst_name` = #{machRent.cst_name}, `rent_start` = #{machRent.rent_start}, `rent_end` = #{machRent.rent_end}, " +
            "`rent_bill_date` = #{machRent.rent_bill_date}, `m_name` = #{machRent.m_name}, `rent_supp_value` = #{machRent.rent_supp_value}, " +
            "`m_name` = #{machRent.m_name}, `rent_supp_value` = #{machRent.rent_supp_value}, " +
            "`rent_tax` = #{machRent.rent_tax}, `rent_collect_date` = #{machRent.rent_collect_date}, `rent_collect_value` = #{machRent.rent_collect_value}, " +
            "`rent_misu` = #{machRent.rent_misu}, `rent_etc` = #{machRent.rent_etc}, `rent_regit` = #{machRent.rent_regit} WHERE `rent_id` = #{machRent.rent_id}")
    int update(@Param("machRent") MachRent machRent);

    @Delete("DELETE FROM mach_rent WHERE rent_id = #{machRent.rent_id}")
    int delete(@Param("machRent")MachRent machRent);
}
