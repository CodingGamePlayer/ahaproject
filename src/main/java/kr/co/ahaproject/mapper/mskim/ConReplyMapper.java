package kr.co.ahaproject.mapper.mskim;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ahaproject.dto.ConReplyDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.ConReply;

@Mapper
public interface ConReplyMapper {
	
	@Insert("INSERT INTO con_reply(cst_id, rp_title, rp_body, rp_reg_date) "+ 
			"VALUES(#{c.cst_id}, #{c.rp_title}, #{c.rp_body}, now())")
	int regist(@Param("c") ConReply conReply);

	List<ConReplyDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
	
	int getCount(PageRequestDTO pageRequestDTO);
	
	@Select("SELECT * FROM con_reply "+ 
			"WHERE rp_id = #{c.rp_id}")
	ConReplyDTO selectOne(@Param("c") ConReplyDTO conReplyDTO);
	
	@Update("UPDATE con_reply SET cst_id = #{c.cst_id}, rp_title=#{c.rp_title}, "+ 
			"rp_body = #{c.rp_body}, rp_mod_date=now(), rp_finished = #{c.rp_finished} "+ 
			"WHERE rp_id=#{c.rp_id}")
	int update(@Param("c") ConReply conReply);
	
	@Delete("DELETE FROM con_reply WHERE rp_id = #{c.rp_id}")
	int delete(@Param("c") ConReply conReply);
}
