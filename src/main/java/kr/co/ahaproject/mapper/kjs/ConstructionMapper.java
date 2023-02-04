package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Construction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConstructionMapper {

    @Select("SELECT * FROM construction")
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
}
