package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.dto.AccountListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {


    @Select("SELECT * FROM account WHERE ac_username = #{username}")
    @Results(id = "accountMap", value = {
            @Result(property = "ac_id",column = "ac_id"),
            @Result(property = "cp_id",column = "cp_id"),
            @Result(property = "username",column = "ac_username"),
            @Result(property = "ac_password",column = "ac_password"),
            @Result(property = "ac_person_name",column = "ac_person_name"),
            @Result(property = "ac_role",column = "ac_role"),
            @Result(property = "ac_regdate",column = "ac_regdate"),
    })
    Account findByUsername(@Param("username") String username);

    @Insert("INSERT INTO account (`cp_id`, `ac_username`, `ac_password`, `ac_person_name`) " +
            "VALUES (#{account.cp_id},#{account.username},#{account.ac_password}, #{account.ac_person_name})")
    int register(@Param("account") Account account);

    @Select("SELECT * FROM account ORDER BY ac_id DESC")
    @ResultMap("accountMap")
    List<Account> selectAll();

    @Update("UPDATE account SET ac_role = #{account.ac_role} WHERE ac_id = #{account.ac_id}")
    int changeRole(@Param("account") Account account);

    @Delete("DELETE FROM account WHERE ac_id = #{account.ac_id}")
    int delete(@Param("account") Account account);

    List<AccountListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
