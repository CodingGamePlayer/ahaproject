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
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.entity.Board;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.entity.Reply;

@Mapper
public interface Replymapper {
	
	
	
	
	//게시판 글에대한 댓글조회
	@Select("select*from reply where b_id =#{b_id} order by rp_id desc")
    @Results(id = "ReplyMap", value = {
            @Result(property = "rp_id", column = "rp_id"),
            @Result(property = "b_id", column = "b_id"),
            @Result(property = "rp_body", column = "rp_body"),
            @Result(property = "us_id", column = "us_id")})
		List<ReplyDTO> getdetail(int b_id);
	@Select("SELECT * FROM reply WHERE rp_id = #{rp_id}")
    @ResultMap("ReplyMap")
	ReplyDTO replySelectOne(int rp_id); //댓글 선택조회
	
	
	
	//댓글 작성
	@Insert("insert into reply (b_id,rp_body, us_id) values (#{b_id},#{rp_body}, #{us_id})")
	int replycreate(ReplyDTO dto);
	
	
	
	//댓글 수정
	@Update("update `ahaproject`.`reply` set rp_body=#{reply.rp_body}, us_id=#{reply.us_id} where rp_id = #{reply.rp_id} and b_id = #{reply.b_id}")
	int replyupdate(@Param("reply") ReplyDTO reply); 
	
	
	
	//댓글 삭제
	@Delete("delete from reply where rp_id=#{rp_id}")
	int replydelete(@Param("rp_id") int rp_id);
}
