package kr.co.ahaproject.mapper.kjs;

import java.util.List;

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


@Mapper
public interface ClientMapper {

	
//	cl_id int AI PK 
//	cp_name varchar(45) 
//	cp_num varchar(45) 
//	cp_address varchar(255) 
//	cp_tel varchar(255) 
//	cl_code varchar(255) PK 
//	cl_email varchar(255) 
//	cl_account varchar(255) 
//	cl_file varchar(500) 
//	cl_etc1 varchar(255) 
//	cl_etc2 varchar(255) 
//	cl_etc3 varchar(255)
	
//	고객 등록
    @Insert("INSERT INTO ahaproject.client (cp_num, cp_name, cp_address, cp_tel, cl_code, cl_email, cl_account, cl_file, cl_etc1, cl_etc2, cl_etc3) "
    		+ " VALUES (#{client.cp_num},#{client.cp_name},#{client.cp_address},#{client.cp_tel},#{client.cl_code},#{client.cl_email},#{client.cl_account},#{client.cl_file},#{client.cl_etc1},#{client.cl_etc2},#{client.cl_etc3})")
    int register(@Param("client") Client client);


    
//    고객 리스트
    @Select("SELECT * FROM client")
    @Results(id = "clientMap", value = {
    		@Result(property = "cl_id", column = "cl_id"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cp_num", column = "cp_num"),
            @Result(property = "cp_address", column = "cp_address"),
            @Result(property = "cp_tel", column = "cp_tel"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cl_email", column = "cl_email"),
            @Result(property = "cl_account", column = "cl_account"),
            @Result(property = "cl_file", column = "cl_file"),
            @Result(property = "cl_etc1", column = "cl_etc1"),
            @Result(property = "cl_etc2", column = "cl_etc2"),
            @Result(property = "cl_etc3", column = "cl_etc3")})
    List<Client> selectAll();

//  디테일
    @Select("SELECT * FROM client WHERE cl_id = #{client.cl_id}")
    @ResultMap("clientMap")
    Client findById(@Param("client") Client client);

    
//  고객 수정
    @Update("UPDATE ahaproject.misu SET " +
            "misu_div = #{misu.misu_div}, cp_name = #{misu.cp_name}, cst_code = #{misu.cst_code}, " +
            "misu_manager = #{misu.misu_manager}, misu_value = #{misu.misu_value}, misu_name = #{misu.misu_name}, " +
            "misu_total_value = #{misu.misu_total_value}, misu_collect_date = #{misu.misu_collect_date}, misu_collect_value = #{misu.misu_collect_value}, " +
            "misu_finished = #{misu.misu_finished}, misu_etc = #{misu.misu_etc} WHERE (misu_id = #{misu.misu_id})")
    int update(@Param("client") ClientDTO clientDTO);

}
