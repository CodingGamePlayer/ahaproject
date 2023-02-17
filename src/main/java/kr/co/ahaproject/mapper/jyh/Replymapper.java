package kr.co.ahaproject.mapper.jyh;

import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.dto.ReplyListDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Replymapper {
	
	
	
	
	//게시판 글에대한 댓글조회
	@Select("select*from reply where b_id =#{b_id} order by rp_id desc")
    @Results(id = "ReplyMap", value = {
            @Result(property = "rp_id", column = "rp_id"),
            @Result(property = "b_id", column = "b_id"),
            @Result(property = "rp_body", column = "rp_body"),
            @Result(property = "ac_id", column = "ac_id")})
		List<ReplyDTO> getdetail(int b_id);
	@Select("SELECT * FROM reply WHERE rp_id = #{rp_id}")
    @ResultMap("ReplyMap")
	ReplyDTO replySelectOne(int rp_id); //댓글 선택조회
	
	
	
	//댓글 작성
	@Insert("insert into reply (b_id,rp_body, ac_id) values (#{b_id},#{rp_body}, #{ac_id})")
	int replycreate(ReplyDTO dto);
	
	
	
	//댓글 수정
	@Update("update `ahaproject`.`reply` set rp_body=#{reply.rp_body}, ac_id=#{reply.ac_id} where rp_id = #{reply.rp_id} and b_id = #{reply.b_id}")
	int replyupdate(@Param("reply") ReplyDTO reply); 
	
	
	
	//댓글 삭제
	@Delete("delete from reply where rp_id=#{rp_id}")
	int replydelete(@Param("rp_id") int rp_id);

	@Select("SELECT R.rp_id, R.b_id, R.rp_body, A.ac_id, A.ac_username, A.ac_person_name " +
			"FROM reply R JOIN account A ON R.ac_id = A.ac_id " +
			"WHERE R.b_id = #{id}")
	@Results(id = "ReplyListDTO", value = {
			@Result(property = "rp_id", column = "rp_id"),
			@Result(property = "b_id", column = "b_id"),
			@Result(property = "ac_id", column = "ac_id"),
			@Result(property = "rp_body", column = "rp_body"),
			@Result(property = "ac_username", column = "ac_username"),
			@Result(property = "ac_person_name", column = "ac_person_name")
	})
	List<ReplyListDTO> findByBoardId(int id);
}
