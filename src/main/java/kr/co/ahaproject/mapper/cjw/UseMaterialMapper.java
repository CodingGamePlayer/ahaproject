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

import kr.co.ahaproject.dto.MaterialDTO;
import kr.co.ahaproject.dto.UseMaterialDTO;

@Mapper
public interface UseMaterialMapper {
	
	/*
    um_id bigint AI PK 
	mt_code varchar(255) 
	cst_code varchar(255) 
	um_where varchar(255) 
	um_amount bigint 
	um_regit tinyint
 */
	
	@Select("SELECT * FROM use_material ORDER BY um_id desc")
	@Results(id = "use_materialMap", value = {
            @Result(property = "um_id", column = "um_id"),
            @Result(property = "mt_code", column = "mt_code"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "um_where", column = "um_where"),
            @Result(property = "um_amount", column = "um_amount"),
            @Result(property = "um_regit", column = "um_regit")
            })
	List<UseMaterialDTO> listAll(); // 전체조회
	
	@Select("SELECT * FROM use_material WHERE um_id = #{um_id}")
	@ResultMap("use_materialMap")
	UseMaterialDTO selectOne(int um_id); // 선택조회
	
	@Insert("INSERT INTO use_material (mt_code, cst_code, um_where, um_amount, um_regit) "
			+ "VALUES (#{mt_code}, #{cst_code}, #{um_where}, #{um_amount}, #{um_regit})")
	int create(UseMaterialDTO dto); // 글작성
	

	@Update("UPDATE `ahaproject`.`use_material` SET " +
            "`mt_code` = #{use_material.mt_code}, `cst_code` = #{use_material.cst_code}, `um_where` = #{use_material.um_where}, " +
            "`um_amount` = #{use_material.um_amount}, `um_regit` = #{use_material.um_regit}" +
            " WHERE (`um_id` = #{use_material.um_id})")
	int update(@Param("use_material") UseMaterialDTO dto); // 글수정
	
	
	@Delete("DELETE FROM `ahaproject`.`use_material` WHERE um_id = #{um_id}")
	int delete(@Param("um_id") int um_id); // 글삭제

}
