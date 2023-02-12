package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.dto.MachRentListDTO;
import kr.co.ahaproject.entity.MachRent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MachrentMapper {

@Insert("INSERT INTO mach_rent(cst_code, rent_start, rent_end, rent_bill_date, m_code, rent_supp_value, " +
        "rent_tax, rent_collect_date, rent_collect_value, rent_misu, rent_finished, rent_etc) " +
        "VALUES (#{machRent.cst_code}, #{machRent.rent_start}, #{machRent.rent_end}, #{machRent.rent_bill_date}, " +
        "#{machRent.m_code}, #{machRent.rent_supp_value}, #{machRent.rent_tax}, #{machRent.rent_collect_date}, " +
        "#{machRent.rent_collect_value}, #{machRent.rent_misu}, #{machRent.rent_finished}, #{machRent.rent_etc})")
    int register(@Param("machRent") MachRent machRent);


    @Select("SELECT * FROM mach_rent ORDER BY rent_id DESC")
    @Results(id = "machRentMap", value = {
            @Result(property = "rent_id", column = "rent_id"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "rent_start", column = "rent_start"),
            @Result(property = "rent_end", column = "rent_end"),
            @Result(property = "rent_bill_date", column = "rent_bill_date"),
            @Result(property = "m_code", column = "m_code"),
            @Result(property = "rent_supp_value", column = "rent_supp_value"),
            @Result(property = "rent_tax", column = "rent_tax"),
            @Result(property = "rent_collect_date", column = "rent_collect_date"),
            @Result(property = "rent_collect_value", column = "rent_collect_value"),
            @Result(property = "rent_misu", column = "rent_misu"),
            @Result(property = "rent_etc", column = "rent_etc"),
            @Result(property = "rent_finished", column = "rent_finished")
    })
    List<MachRent> selectAll();

    @Select("SELECT * FROM mach_rent WHERE rent_id = #{machRent.rent_id}")
    @ResultMap("machRentMap")
    MachRent findById(@Param("machRent") MachRent machRent);

    @Update("UPDATE `ahaproject`.`mach_rent` SET " +
            "`cst_code` = #{machRent.cst_code}, `rent_start` = #{machRent.rent_start}, `rent_end` = #{machRent.rent_end}, " +
            "`rent_bill_date` = #{machRent.rent_bill_date},`m_code` = #{machRent.m_code}, `rent_supp_value` = #{machRent.rent_supp_value}, " +
            "`rent_tax` = #{machRent.rent_tax}, `rent_collect_date` = #{machRent.rent_collect_date}, " +
            "`rent_collect_value` = #{machRent.rent_collect_value}, `rent_misu` = #{machRent.rent_misu}, `rent_etc` = #{machRent.rent_etc}, " +
            "`rent_finished` = #{machRent.rent_finished} " +
            "WHERE `rent_id` = #{machRent.rent_id}")
    int update(@Param("machRent") MachRent machRent);

    @Delete("DELETE FROM mach_rent WHERE rent_id = #{machRent.rent_id}")
    int delete(@Param("machRent")MachRent machRent);

    @Select("SELECT A.rent_id, C.cst_name, A.rent_start, A.rent_end, A.rent_bill_date, B.m_name, A.rent_supp_value, " +
            "A.rent_tax, A.rent_collect_date, A.rent_collect_value, A.rent_misu, A.rent_finished, A.rent_etc, B.m_kind " +
            "FROM mach_rent A JOIN machine B " +
            "ON A.m_code = B.m_code JOIN construction C " +
            "ON A.cst_code = C.cst_code ORDER BY A.rent_id DESC")
    List<MachRentListDTO> selectAllForList();

    @Select("SELECT A.rent_id, C.cst_name, A.rent_start, A.rent_end, A.rent_bill_date, B.m_name, A.rent_supp_value, " +
            "A.rent_tax, A.rent_collect_date, A.rent_collect_value, A.rent_misu, A.rent_finished, A.rent_etc, B.m_kind " +
            "FROM mach_rent A JOIN machine B " +
            "ON A.m_code = B.m_code JOIN construction C " +
            "ON A.cst_code = C.cst_code " +
            "WHERE B.m_kind = #{kind} " +
            "ORDER BY A.rent_id DESC ")
    List<MachRentListDTO> selectAllFindByKind(String kind);

    @Select("SELECT A.rent_id, C.cst_name, A.rent_start, A.rent_end, A.rent_bill_date, B.m_name, A.rent_supp_value, " +
            "A.rent_tax, A.rent_collect_date, A.rent_collect_value, A.rent_misu, A.rent_finished, A.rent_etc, B.m_kind " +
            "FROM mach_rent A JOIN machine B " +
            "ON A.m_code = B.m_code JOIN construction C " +
            "ON A.cst_code = C.cst_code " +
            "ORDER BY A.rent_id DESC ")
    List<MachRentListDTO> selectAllWithoutKind();

}
