package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyMapper {

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


}
