package kr.co.ahaproject.mapper.mskim;

import java.util.List;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Client;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.ahaproject.entity.Card;

@Mapper
public interface CardMapper {
	
	
	// 카드 전체 리스트 조회
	@Select("select * from card")
	@Results(id = "cardMap", value= {
			@Result(property = "card_id", column = "card_id"),
			@Result(property = "cl_code", column = "cl_code"),
			@Result(property = "card_name", column = "card_name"),
			@Result(property = "card_class", column = "card_class"),
			@Result(property = "card_type", column = "card_type"),
			@Result(property = "card_company", column = "card_company"),
			@Result(property = "card_num", column = "card_num"),
			@Result(property = "card_endnum", column = "card_endnum"),
			@Result(property = "card_exp_date", column = "card_exp_date"),
	})
	List<Card> selectAll();
	
	// 카드 거래처별 조회
	@Select("select * from card where cl_code = #{cl_code}")
	@ResultMap("cardMap")
	List<Card> findByClient(@Param("cl_code") String cl_code);
	
	// 카드 정보
	@Select("select * from card where card_id = #{card_id}")
	@ResultMap("cardMap")
	Card findByCard(@Param("card_id") int card_id);
	
	// 카드 정보 등록
	@Insert("insert into card(cl_code, card_name, card_class, card_type,"+
			" card_company, card_num, card_endnum, card_exp_date)"+ 
			" values(#{card.cl_code}, #{card.card_name}, #{card.card_class}, #{card.card_type},"+
			" #{card.card_company}, #{card.card_num}, #{card.card_endnum}, #{card.card_exp_date})")
	int register(@Param("card") Card card);
	
	// 카드 정보 수정
	@Update("update card set cl_code = #{card.cl_code}, card_name=#{card.card_name}, "+ 
			"card_class = #{card.card_class}, card_type = #{card.card_type}, card_company = #{card.card_company}, "+ 
			"card_num = #{card.card_num}, card_endnum = #{card.card_endnum}, card_exp_date = #{card.card_exp_date} "+ 
			"where card_id = #{card.card_id}")
	int update(@Param("card") Card card);
	
	// 카드 정보 삭제
	@Delete("delete from card where card_id = #{card.card_id}")
	int delete(@Param("card") Card card);

	List<Card> selectAllForPaging(PageRequestDTO pageRequestDTO);

	int getCount(PageRequestDTO pageRequestDTO);
}
