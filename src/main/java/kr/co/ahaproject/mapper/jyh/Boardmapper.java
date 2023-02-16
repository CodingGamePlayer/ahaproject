//  int rp_id;
//    int b_id;
//    String rp_body;
//    int us_id;

package kr.co.ahaproject.mapper.jyh;

import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.dto.BoardListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface Boardmapper {
	
	
	//전체조회
	@Select("SELECT * FROM board")
    @Results(id = "BoardMap", value = {
            @Result(property = "b_id", column = "b_id"),
            @Result(property = "ct_id", column = "ct_id"),
            @Result(property = "ac_id", column = "ac_id"),
            @Result(property = "b_title", column = "b_title"),
            @Result(property = "b_body", column = "b_body"),
            @Result(property = "b_filename", column = "b_filename"),
			@Result(property = "b_uuid", column = "b_uuid")})
    List<BoardDTO> listAll();
	
	@Select("SELECT * FROM board WHERE b_id = #{b_id}")
    @ResultMap("BoardMap")
	BoardDTO SelectOne(int b_id); //선택조회
	
	
	@Select("SELECT * FROM board WHERE ct_id = #{ct_id}")
    @ResultMap("BoardMap")
	BoardDTO CategoryOne(int ct_id); //카테고리 선택
    
	
	
	//글 작성 
	@Insert("insert into board(ct_id,ac_id,b_title,b_body,b_filename,b_uuid) values(#{ct_id},#{ac_id},#{b_title},#{b_body},#{b_filename},#{b_uuid})")
      int create(BoardDTO dto);
	
	//글 수정
	 @Update("UPDATE `ahaproject`.`board` SET " +
	            "`ct_id` = #{board.ct_id}, `ac_id` = #{board.ac_id}, " +
	            "`b_title` = #{board.b_title}, `b_body` = #{board.b_body}, " +
	            "`b_filename` = #{board.b_filename}, `b_uuid`= #{board.b_uuid} WHERE (`b_id` = #{board.b_id})")
	    int update(@Param("board") BoardDTO board); 
	
	
	//글 삭제 
	@Delete("delete from `ahaproject`.`board` where b_id = #{b_id}")
	int delete(@Param("b_id") int b_id);

	List<BoardListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

	int getCount(PageRequestDTO pageRequestDTO);
}
