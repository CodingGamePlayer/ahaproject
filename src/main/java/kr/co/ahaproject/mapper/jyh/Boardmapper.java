package kr.co.ahaproject.mapper.jyh;

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
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.entity.Board;

@Mapper
public interface Boardmapper {
	
	
	//전체조회
	@Select("SELECT * FROM board")
    @Results(id = "BoardMap", value = {
            @Result(property = "b_id", column = "b_id"),
            @Result(property = "ct_id", column = "ct_id"),
            @Result(property = "us_id", column = "us_id"),
            @Result(property = "b_title", column = "b_title"),
            @Result(property = "b_body", column = "b_body"),
            @Result(property = "b_etc", column = "b_etc"),
            @Result(property = "b_file", column = "b_file")})
    List<BoardDTO> listAll();
	
	@Select("SELECT * FROM board WHERE b_id = #{board.b_id}")
    @ResultMap("BoardMap")
    Board findById(@Param("board") Board board);
	
	
	//글 작성 
	@Insert("insert into board(`b_title`,`b_body`,`b_etc`,`b_file`) values(#{board.b_title},#{board.b_body},#{board.b_etc},#{board.b_file}")
      int create(@Param("board") Board board);
	
	//글 수정
	 @Update("UPDATE `ahaproject`.`board` SET " +
	            "`ct_id` = #{board.ct_id}, `us_id` = #{board.us_id}, " +
	            "`b_title` = #{board.b_title}, `b_body` = #{board.b_body}, `b_etc` = #{board.b_etc}, " +
	            "`b_file` = #{board.b_file} WHERE (`b_id` = #{board.b_id})")
	    int update(@Param("board") Board board);

	
	//선택조회
	@Select("select* from board where `b_id` = #{board.b_id}")
	BoardDTO SelectOne(@Param("board") Board board);
	
	//글 삭제 
	@Delete("delete from board where `b_id` =#{board.b_id}")
	int delete(@Param("board") Board board);
}
