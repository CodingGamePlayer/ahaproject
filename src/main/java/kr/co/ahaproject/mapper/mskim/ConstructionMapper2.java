package kr.co.ahaproject.mapper.mskim;

import kr.co.ahaproject.entity.Construction;

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
public interface ConstructionMapper2 {

    @Select("select * from construction")
    @Results(id = "constructionMap", value = {
            @Result(property = "cst_id", column = "cst_id"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "cst_name", column = "cst_name"),
            @Result(property = "cst_period", column = "cst_period"),
            @Result(property = "cst_start", column = "cst_start"),
            @Result(property = "cst_end", column = "cst_end"),
            @Result(property = "cst_toal_pay", column = "cst_toal_pay"),
            @Result(property = "cst_1st_pay", column = "cst_1st_pay"),
            @Result(property = "cst_collect_date", column = "cst_collect_date"),
            @Result(property = "cst_finised", column = "cst_finised"),
            @Result(property = "cst_etc1", column = "cst_etc1"),
            @Result(property = "cst_etc2", column = "cst_etc2"),
            @Result(property = "cst_etc3", column = "cst_etc3"),
            @Result(property = "cst_file", column = "cst_file") })
    List<Construction> selectAll();
    
    @Select("select * from construction where cst_id = #{cst.cst_id}")
    @ResultMap("constructionMap")
    Construction findByCst(@Param("cst") Construction cst);
    
    @Insert("insert into construction(cst_code, cst_name, cst_period, cst_start, cst_end, "+ 
    		"cst_toal_pay, cst_1st_pay, cst_collect_date, cst_finised, cst_etc1, cst_etc2, "+ 
    		"cst_etc3, cst_file) values(#{cst.cst_code}, #{cst.cst_name}, #{cst.cst_period}, #{cst.cst_start}, "+ 
    		"#{cst.cst_end}, #{cst.cst_toal_pay}, #{cst.cst_1st_pay}, #{cst.cst_collect_date}, #{cst.cst_finised}, "+ 
    		"#{cst.cst_etc1}, #{cst.cst_etc2}, #{cst.cst_etc3}, #{cst.cst_file})")
    int register(@Param("cst") Construction cst);
    
    @Update("update construction set cst_code=#{cst.cst_code}, cst_name=#{cst.cst_name}, "+
    		"cst_period=#{cst.cst_period}, cst_start=#{cst.cst_start}, cst_end=#{cst.cst_end}, "+ 
    		"cst_toal_pay=#{cst.cst_toal_pay}, cst_1st_pay=#{cst.cst_1st_pay}, cst_collect_date=#{cst.cst_collect_date}, "+ 
    		"cst_finised=#{cst.cst_finised}, cst_etc1=#{cst.cst_etc1}, cst_etc2=#{cst.cst_etc2}, "+ 
    		"cst_etc3= #{cst.cst_etc3}, cst_file=#{cst.cst_file} where cst_id = #{cst.cst_id}")
    int update(@Param("cst") Construction cst);
    
    @Delete("delete from construction where cst_id = #{cst.cst_id}")
    int delete(@Param("cst") Construction cst);
}