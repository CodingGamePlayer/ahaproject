package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Company;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CompanyMapper {

//	전체조회
    @Select("SELECT * FROM company")
    @Results(id = "companyMap", value = {
            @Result(property = "cp_id", column = "cp_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cp_num", column = "cp_num"),
            @Result(property = "cp_address", column = "cp_address"),
            @Result(property = "cp_tel", column = "cp_tel"),
            @Result(property = "cp_type", column = "cp_type"),
            @Result(property = "cp_head_name", column = "cp_head_name"),
            @Result(property = "cp_head_id", column = "cp_head_id"),
            @Result(property = "cp_sector", column = "cp_sector"),
            @Result(property = "cp_establish", column = "cp_establish"),
            @Result(property = "cp_open", column = "cp_open"),
            @Result(property = "cp_eng_name", column = "cp_eng_name"),
            @Result(property = "cp_eng_address", column = "cp_eng_address"),
            @Result(property = "cp_eng_head_name", column = "cp_eng_head_name"),
            @Result(property = "cp_domain", column = "cp_domain"),
            @Result(property = "cp_file", column = "cp_file") })
    List<Company> selectAll();
    
//  등록
    @Insert("INSERT INTO ahaproject.company "
    		+ "(cp_name,"
    		+ "cp_num,"
    		+ "cp_address,"
    		+ "cp_tel,"
    		+ "cp_type,"
    		+ "cp_head_name,"
    		+ "cp_head_id,"
    		+ "cp_sector,"
    		+ "cp_establish,"
    		+ "cp_open,"
    		+ "cp_eng_name,"
    		+ "cp_eng_address,"
    		+ "cp_eng_head_name,"
    		+ "cp_domain,"
    		+ "cp_filename,"
    		+ "cp_uuid)"
    		+ " VALUES "
    		+ "(#{company.cp_name},"
    		+ "#{company.cp_num},"
    		+ "#{company.cp_address},"
    		+ "#{company.cp_tel},"
    		+ "#{company.cp_type},"
    		+ "#{company.cp_head_name},"
    		+ "#{company.cp_head_id},"
    		+ "#{company.cp_sector},"
    		+ "#{company.cp_establish},"
    		+ "#{company.cp_open},"
    		+ "#{company.cp_eng_name},"
    		+ "#{company.cp_eng_address},"
    		+ "#{company.cp_eng_head_name},"
    		+ "#{company.cp_domain},"
    		+ "#{company.cp_filename},"
    		+ "#{company.cp_uuid});")
    int register(@Param("company")Company company);
    
//  선택조회
    @Select("SELECT * "
    		+ "FROM ahaproject.company "
    		+ "where cp_id = #{company.cp_id}")
    @ResultMap("companyMap")
    Company findById(@Param("company")Company company);
    
//  수정
    @Update("UPDATE ahaproject.company "
    		+ "SET "
    		+ "cp_name = #{company.cp_name},"
    		+ "cp_num = #{company.cp_num},"
    		+ "cp_address = #{company.cp_address},"
    		+ "cp_tel = #{company.cp_tel},"
    		+ "cp_type = #{company.cp_type},"
    		+ "cp_head_name = #{company.cp_head_name},"
    		+ "cp_head_id = #{company.cp_head_id},"
    		+ "cp_sector = #{company.cp_sector},"
    		+ "cp_establish = #{company.cp_establish},"
    		+ "cp_open = #{company.cp_open},"
    		+ "cp_eng_name = #{company.cp_eng_name},"
    		+ "cp_eng_address = #{company.cp_eng_address},"
    		+ "cp_eng_head_name = #{company.cp_eng_head_name},"
    		+ "cp_domain = #{company.cp_domain},"
    		+ "cp_filename = #{company.cp_filename},"
    		+ "cp_uuid = #{company.cp_uuid}"
    		+ " WHERE cp_id = #{company.cp_id};")
    int update(@Param("company") Company company);
    
//    삭제
    @Delete("DELETE FROM ahaproject.company "
    		+ "WHERE cp_id = #{company.cp_id}")
    int delete(@Param("company") Company company);

}
