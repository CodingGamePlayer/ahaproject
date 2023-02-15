package kr.co.ahaproject.mapper.mskim;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.UseCardJoinDTO;
import kr.co.ahaproject.entity.UseCard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UseCardMapper {
	
	//카드 사용 내역 전체 조회
	@Select("select use_card.*, card.card_name, card.card_class, card.card_type, card.card_endnum "+ 
			"from use_card left join card on use_card.card_id = card.card_id order by uc_id desc ")
	@Results(id = "ucjMap", value= {
			@Result(property = "uc_id", column = "uc_id"),
			@Result(property = "uc_money", column = "uc_money"),
			@Result(property = "uc_where", column = "uc_where"),
			@Result(property = "uc_date", column = "uc_date"),
			@Result(property = "uc_etc", column = "uc_etc"),
			@Result(property = "card_id", column = "card_id"),
			@Result(property = "card_name", column = "card_name"),
			@Result(property = "card_class", column = "card_class"),
			@Result(property = "card_type", column = "card_type"),
			@Result(property = "card_endnum", column = "card_endnum")
	})
	List<UseCardJoinDTO> selectAll();




	//카드별 사용 내역 조회
	@Select("select use_card.*, card.card_name, card.card_class, card.card_type, card.card_endnum "+
			"from use_card left join card on use_card.card_id = card.card_id "+
			"where use_card.card_id = #{card_id} order by uc_id desc ")
	@ResultMap("ucjMap")
	List<UseCardJoinDTO> selectOne(@Param("card_id") int card_id);
	
	//카드 사용 내역 등록
	@Insert("insert into use_card(card_id, uc_money, uc_where, uc_date, uc_etc) values (#{uc.card_id}, "+ 
			"#{uc.uc_money}, #{uc.uc_where}, #{uc.uc_date}, #{uc.uc_etc})")
	int register(@Param("uc") UseCard uc);
	
	//카드 사용내역 수정을 위한 uc-id 조회 
	@Select("select use_card.*, card.card_name, card.card_class, card. card_type, card.card_endnum "+ 
			"from use_card left join card on use_card.card_id = card.card_id "+ 
			"where use_card.uc_id = #{uc_id} ")
	@ResultMap("ucjMap")
	UseCardJoinDTO getFindUcId(@Param("uc_id") int uc_id);
	
	//카드 사용내역 수정
	@Update("update use_card set card_id = #{uc.card_id}, uc_money=#{uc.uc_money}, uc_where=#{uc.uc_where}, "+ 
			"uc_date=#{uc.uc_date}, uc_etc=#{uc.uc_etc} where uc_id=#{uc.uc_id}")
	int update(@Param("uc") UseCard uc);
	
	//카드 사용내역 삭제
	@Delete("delete from use_card where uc_id = #{uc.uc_id}")
	int delete(@Param("uc") UseCard uc);
  
    List<UseCardJoinDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

	int getCount(PageRequestDTO pageRequestDTO);
}
