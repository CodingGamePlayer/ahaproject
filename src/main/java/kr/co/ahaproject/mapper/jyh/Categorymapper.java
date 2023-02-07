//int ct_id;
//String ct_name;
//boolean ct_use;
package kr.co.ahaproject.mapper.jyh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.ahaproject.dto.CategoryDTO;

@Mapper
public interface Categorymapper {
	
	
	//카테고리 전체 조회
	@Select("select * from category")
	List<CategoryDTO> listAll();
	
	//카테코리 선택조회
	@Select("select * from category where ct_id = #{ct_id}")
	CategoryDTO SelectOne(int ct_id );

}
