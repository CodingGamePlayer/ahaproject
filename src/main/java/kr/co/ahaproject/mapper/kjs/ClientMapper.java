package kr.co.ahaproject.mapper.kjs;

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

import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.entity.Company;


@Mapper
public interface ClientMapper {
	
//	고객 등록
    @Insert("INSERT INTO ahaproject.client (cp_num, cp_name, cp_address, cp_tel, cl_code, cl_email, cl_account, cl_filename, cl_uuid, cl_etc1, cl_etc2, cl_etc3) "
    		+ " VALUES (#{client.cp_num},#{client.cp_name},#{client.cp_address},#{client.cp_tel},#{client.cl_code},#{client.cl_email},#{client.cl_account},#{client.cl_filename},#{client.cl_uuid},#{client.cl_etc1},#{client.cl_etc2},#{client.cl_etc3})")
    int register(@Param("client") Client client);


    
//    고객 리스트
    @Select("SELECT * FROM client order by cl_id desc")
    @Results(id = "clientMap", value = {
    		@Result(property = "cl_id", column = "cl_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cp_num", column = "cp_num"),
            @Result(property = "cp_address", column = "cp_address"),
            @Result(property = "cp_tel", column = "cp_tel"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cl_email", column = "cl_email"),
            @Result(property = "cl_account", column = "cl_account"),
            @Result(property = "cl_filename", column = "cl_filename"),
            @Result(property = "cl_uuid", column = "cl_uuid"),
            @Result(property = "cl_etc1", column = "cl_etc1"),
            @Result(property = "cl_etc2", column = "cl_etc2"),
            @Result(property = "cl_etc3", column = "cl_etc3")})
    List<Client> selectAll();

//  디테일
    @Select("SELECT * FROM client WHERE cl_id = #{client.cl_id}")
    @ResultMap("clientMap")
    Client findById(@Param("client") Client client);

    
//  고객 수정
    @Update("UPDATE ahaproject.client SET "
    		+ "cp_name = #{client.cp_name},"
    		+ "cp_num = #{client.cp_num},"
    		+ "cp_address = #{client.cp_address},"
    		+ "cp_tel = #{client.cp_tel},"
    		+ "cl_code = #{client.cl_code},"
    		+ "cl_email = #{client.cl_email},"
    		+ "cl_account = #{client.cl_account},"
    		+ "cl_filename = #{client.cl_filename},"
    		+ "cl_uuid = #{client.cl_uuid},"
    		+ "cl_etc1 = #{client.cl_etc1},"
    		+ "cl_etc2 = #{client.cl_etc2},"
    		+ "cl_etc3 = #{client.cl_etc3}"
    		+ "WHERE cl_id = #{client.cl_id}")
    int update(@Param("client") Client client);
    
//  고객 삭제
//  삭제
  @Delete("DELETE FROM ahaproject.client "
  		+ "WHERE cl_id = #{client.cl_id}")
  int delete(@Param("client") Client client);
  
// 거래처 코드
  @Select ("select ifnull(max(cl_id)+1, 0) from ahaproject.client")
  int maxNum();
}
