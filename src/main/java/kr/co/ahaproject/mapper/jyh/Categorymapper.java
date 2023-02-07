//int ct_id;
//String ct_name;
//boolean ct_use;
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
import kr.co.ahaproject.dto.CategoryDTO;
import kr.co.ahaproject.entity.Category;

@Mapper
public interface Categorymapper {
	
	
	//카테고리 전체 조회
	@Select("select * from category")
    @Results(id = "CategoryMap", value = {
            @Result(property = "ct_id", column = "ct_id"),
            @Result(property = "ct_name", column = "ct_name"),
            @Result(property = "ct_use", column = "ct_use")})
	List<CategoryDTO> listAll();
            @Select("SELECT * FROM category WHERE ct_id = #{category.ct_id}")
            @ResultMap("CategoryMap")
            Category findById(@Param("category") Category category);
	
	//카테고리 선택조회
	@Select("select * from category where ct_id = #{category.ct_id}")
	CategoryDTO SelectOne(int ct_id);
	
	
	//카테고리 추가
	@Insert("inset into category (ct_id,ct_name,ct_use) values(#{category.ct_id},#{category.ct_name},#{category.ct_use}")
	int Catecreate(CategoryDTO dto);
	
	//수정
	@Update("update category set ct_name =#{category.ct_name}, ct_use = #{category.ct_use} where ct_id = #{category.ct_id}")
	int Cateupdate(CategoryDTO dto);
	
	//삭제
	@Delete("delete from category where ct_id =#{category.ct_id}")
	int Catedelete(int ct_id);
	
	

}
