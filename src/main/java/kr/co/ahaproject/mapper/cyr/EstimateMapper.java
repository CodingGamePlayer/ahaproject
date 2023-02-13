package kr.co.ahaproject.mapper.cyr;

import kr.co.ahaproject.entity.Estimate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EstimateMapper {

    @Select("select * from estimate order by es_id desc")
    @Results(id = "estimateMap", value = {
            @Result(property = "es_id", column = "es_id"),
            @Result(property = "es_code", column = "es_code"),
            @Result(property = "es_title", column = "es_title"),
            @Result(property = "es_body", column = "es_body"),
            @Result(property = "es_uuid", column = "es_uuid"),
            @Result(property = "es_filename", column = "es_filename"),
            @Result(property = "es_date", column = "es_date"),
            @Result(property = "us_id", column = "us_id"),
            @Result(property = "es_etc1", column = "es_etc1"),
            @Result(property = "es_etc2", column = "es_etc2"),
    })
    List<Estimate> listAll();

    @Select("select * from estimate where es_id = #{es_id}")
    Estimate selectOne(int es_id);
    
    //id 선택하기
    @Select("select es_id from estimate order by es_id desc limit 1")
    int selectid();

    @Select("select count(*) from estimate")
    int count();

    @Insert("insert into estimate (es_code,es_title,es_body,es_filename,es_uuid,es_date,us_id, es_etc1, es_etc2) values (#{es_code},#{es_title},#{es_body},#{es_filename},#{es_uuid},#{es_date},#{us_id},#{es_etc1},#{es_etc2})")
    int insert(Estimate estimate);

    @Update("update estimate set es_code=#{es_code}, es_title=#{es_title}, es_body=#{es_body}, es_filename=#{es_filename}, es_uuid=#{es_uuid}, es_date=#{es_date}, us_id=#{us_id}, es_etc1=#{es_etc1},es_etc2=#{es_etc2} where es_id=#{es_id}")
    int update(Estimate estimate);

    @Delete("delete from estimate where es_id=#{es_id}")
    int delete(int es_id);

}
