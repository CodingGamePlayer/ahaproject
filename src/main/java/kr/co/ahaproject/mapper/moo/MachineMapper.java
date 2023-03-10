package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Machine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MachineMapper {
    @Insert("INSERT INTO machine(m_code, m_name, m_equip_num, m_type, m_kind, " +
            "m_price, m_tax, m_date, m_uuid, m_filename, m_etc1, m_etc2, m_etc3) " +
            "VALUES (#{machine.m_code}, #{machine.m_name}, #{machine.m_equip_num}, #{machine.m_type}, #{machine.m_kind}" +
            ", #{machine.m_price}, #{machine.m_tax}, #{machine.m_date}, #{machine.m_uuid}, #{machine.m_filename}" +
            ", #{machine.m_etc1}, #{machine.m_etc2}, #{machine.m_etc3})")
    int register(@Param("machine") Machine machine);

    @Select("SELECT * FROM machine ORDER BY m_id DESC")
    @Results(id = "machineMap", value = {
            @Result(property = "m_id", column = "m_id"),
            @Result(property = "m_code", column = "m_code"),
            @Result(property = "m_name", column = "m_name"),
            @Result(property = "m_equip_num", column = "m_equip_num"),
            @Result(property = "m_type", column = "m_type"),
            @Result(property = "m_kind", column = "m_kind"),
            @Result(property = "m_price", column = "m_price"),
            @Result(property = "m_tax", column = "m_tax"),
            @Result(property = "m_date", column = "m_date"),
            @Result(property = "m_filename", column = "m_filename"),
            @Result(property = "m_etc1", column = "m_etc1"),
            @Result(property = "m_etc2", column = "m_etc2"),
            @Result(property = "m_etc3", column = "m_etc3"),
            @Result(property = "m_uuid", column = "m_uuid"),
            @Result(property = "m_use", column = "m_use")
    })
    List<Machine> selectAll();

    @Select("SELECT * FROM `ahaproject`.`machine` WHERE m_id = #{machine.m_id}")
    @ResultMap("machineMap")
    Machine findById(@Param("machine") Machine machine);

    @Select("SELECT * FROM machine WHERE m_code = #{m_code}")
    @ResultMap("machineMap")
    Machine findByCode(@Param("m_code") String m_code);

    @Update("UPDATE `ahaproject`.`machine` SET " +
            "`m_name` = #{machine.m_name}, `m_equip_num` = #{machine.m_equip_num}, `m_type` = #{machine.m_type}, " +
            "`m_price` = #{machine.m_price}, `m_tax` = #{machine.m_tax}, `m_date` = #{machine.m_date}, " +
            "`m_filename` = #{machine.m_filename}, `m_etc1` = #{machine.m_etc1}, `m_etc2` = #{machine.m_etc2}, " +
            "`m_etc3` = #{machine.m_etc3}, m_uuid = #{machine.m_uuid}, m_kind = #{machine.m_kind}, m_use = #{machine.m_use} " +
            "WHERE `m_id` = #{machine.m_id}")
    int update(@Param("machine") Machine machine);


    @Select("SELECT ifnull((SELECT m_id FROM ahaproject.machine ORDER BY m_id DESC limit 1),0 ) AS m_id From ahaproject.machine union ALL select 0 AS m_id FROM dual LIMIT 1")
    int getm_code();

    @Delete("DELETE FROM machine WHERE m_id = #{machine.m_id}")
    int delete(@Param("machine")Machine machine);

    List<Machine> selectAllForPaging(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);

}
