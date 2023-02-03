package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.entity.Account;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountMapper {


    @Select("SELECT * FROM account WHERE ac_username = #{username}")
    @Results(id = "accountMap", value = {
            @Result(property = "ac_id",column = "ac_id"),
            @Result(property = "cp_name",column = "cp_name"),
            @Result(property = "username",column = "ac_username"),
            @Result(property = "ac_password",column = "ac_password"),
            @Result(property = "ac_person_name",column = "ac_person_name"),
            @Result(property = "ac_role",column = "ac_role"),
            @Result(property = "ac_regdate",column = "ac_regdate"),
    })
    Account findByUsername(@Param("username") String username);

    @Insert("INSERT INTO account (`cp_name`, `ac_username`, `ac_password`, `ac_person_name`) " +
            "VALUES (#{account.cp_name},#{account.username},#{account.ac_password}, #{account.ac_person_name})")
    int register(@Param("account") Account account);


}
