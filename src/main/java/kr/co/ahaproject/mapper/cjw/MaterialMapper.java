package kr.co.ahaproject.mapper.cjw;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import io.swagger.v3.oas.annotations.Parameter;
import kr.co.ahaproject.dto.MaterialDTO;

@Mapper
public interface MaterialMapper {
	
	/*mt_code varchar(255) PK 
	mt_name varchar(255) 
	mt_standard varchar(255) 
	mt_remain bigint 
	mt_etc1 varchar(255) 
	mt_etc2 varchar(255) 
	mt_etc3 varchar(255) 
	mt_file
 * 
 * */
	
	@Select("SELECT * FROM material ORDER BY mt_id desc")
	@Results(id = "MaterialMap", value = {
            @Result(property = "mt_id", column = "mt_id"),
            @Result(property = "mt_code", column = "mt_code"),
            @Result(property = "mt_name", column = "mt_name"),
            @Result(property = "mt_standard", column = "mt_standard"),
            @Result(property = "mt_remain", column = "mt_remain"),
            @Result(property = "mt_etc1", column = "mt_etc1"),
            @Result(property = "mt_etc2", column = "mt_etc2"),
            @Result(property = "mt_etc3", column = "mt_etc3"),
            @Result(property = "mt_filename", column = "mt_filename"),
            @Result(property = "mt_uuid", column = "mt_uuid")}
	)
	List<MaterialDTO> listAll(); // 전체조회
	
	@Select("SELECT * FROM material WHERE mt_id = #{mt_id}")
	@ResultMap("MaterialMap")
	MaterialDTO selectOne(int mt_id); // 선택조회
	
	@Insert("INSERT INTO material (mt_code, mt_name, mt_standard, mt_remain, mt_etc1, mt_etc2, mt_etc3, mt_filename, mt_uuid) "
			+ "VALUES (#{mt_code}, #{mt_name}, #{mt_standard}, #{mt_remain}, #{mt_etc1}, #{mt_etc2}, #{mt_etc3}, #{mt_filename}, #{mt_uuid})")
	int create(MaterialDTO dto); // 글작성
	

	@Update("UPDATE `ahaproject`.`material` SET " +
            "`mt_code` = #{material.mt_code}, `mt_name` = #{material.mt_name}, `mt_standard` = #{material.mt_standard}, " +
            "`mt_remain` = #{material.mt_remain}, `mt_etc1` = #{material.mt_etc1}, `mt_etc2` = #{material.mt_etc2},  " +
            "`mt_etc3` = #{material.mt_etc3}, `mt_filename` = #{material.mt_filename}, `mt_uuid` = #{material.mt_uuid} WHERE (`mt_id` = #{material.mt_id})")
	int update(@Param("material") MaterialDTO dto); // 글수정
	
	
	@Delete("DELETE FROM `ahaproject`.`material` WHERE mt_id = #{mt_id}")
	int delete(@Param("mt_id") int mt_id); // 글삭제

}
