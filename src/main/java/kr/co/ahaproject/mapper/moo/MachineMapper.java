package kr.co.ahaproject.mapper.moo;

import kr.co.ahaproject.entity.Machine;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MachineMapper {
    @Insert("INSERT INTO `ahaproject`.`machine` (`m_code`,`m_name`, `m_equip_num`, `m_type`, `m_price`,`m_tax`,`m_date`,`m_file`,`m_etc1`,`m_etc2`,`m_etc3`)" +
    "VALUES (#{machine.m_code}, #{machine.m_name}, #{machine.m_equip_num}, #{machine.m_type}, #{machine.m_price}, #{machine.m_tax}, #{machine.m_date}, #{machine.m_file}, #{machine.m_etc1}, #{machine.m_etc2}, #{machine.m_etc3})")
    int register(@Param("machine") Machine machine);

    @Select("SELECT * FROM machine ORDER BY m_id DESC")
    @Results(id = "machineMap", value = {
            @Result(property = "m_id", column = "m_id"),
            @Result(property = "m_code", column = "m_code"),
            @Result(property = "m_name", column = "m_name"),
            @Result(property = "m_equip_num", column = "m_equip_num"),
            @Result(property = "m_type", column = "m_type"),
            @Result(property = "m_price", column = "m_price"),
            @Result(property = "m_tax", column = "m_tax"),
            @Result(property = "m_date", column = "m_date"),
            @Result(property = "m_file", column = "m_file"),
            @Result(property = "m_etc1", column = "m_etc1"),
            @Result(property = "m_etc2", column = "m_etc2"),
            @Result(property = "m_etc3", column = "m_etc3")})
    List<Machine> selectAll();
}
