package kr.co.ahaproject.mapper.jungi;

import kr.co.ahaproject.dto.BillingResponseDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.Billing;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BillingMapper {

    @Select("select * from billing")
    @Results(id = "billingMap", value = {
            @Result(property = "bl_id", column = "bl_id"),
            @Result(property = "bl_work_date", column = "bl_work_date"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "bl_pub_date", column = "bl_pub_date"),
            @Result(property = "bl_supp_value", column = "bl_supp_value"),
            @Result(property = "bl_tax", column = "bl_tax"),
            @Result(property = "bl_total_value", column = "bl_total_value"),
            @Result(property = "bl_collect_date", column = "bl_collect_date"),
            @Result(property = "bl_difference", column = "bl_difference"),
            @Result(property = "bl_uuid1", column = "bl_uuid1"),
            @Result(property = "bl_filename1", column = "bl_filename1"),
            @Result(property = "bl_uuid2", column = "bl_uuid2"),
            @Result(property = "bl_filename2", column = "bl_filename2")
    })
    List<Billing> selectAll();

    @Select("select bl.*, cl.cp_name, cl.cl_code, cst.cst_name from billing bl " +
            "join client cl on cl.cl_id = bl.cl_id " +
            "join construction cst on cst.cst_code = bl.cst_code " +
            "WHERE bl_id = #{billing.bl_id}")
    @Results(id = "billingResponseMap", value = {
            @Result(property = "bl_id", column = "bl_id"),
            @Result(property = "bl_work_date", column = "bl_work_date"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cst_code", column = "cst_code"),
            @Result(property = "bl_pub_date", column = "bl_pub_date"),
            @Result(property = "bl_supp_value", column = "bl_supp_value"),
            @Result(property = "bl_tax", column = "bl_tax"),
            @Result(property = "bl_total_value", column = "bl_total_value"),
            @Result(property = "bl_collect_date", column = "bl_collect_date"),
            @Result(property = "bl_difference", column = "bl_difference"),
            @Result(property = "cp_name", column = "cp_name"),
            @Result(property = "cl_code", column = "cl_code"),
            @Result(property = "cst_name", column = "cst_name"),
            @Result(property = "bl_uuid1", column = "bl_uuid1"),
            @Result(property = "bl_filename1", column = "bl_filename1"),
            @Result(property = "bl_uuid2", column = "bl_uuid2"),
            @Result(property = "bl_filename2", column = "bl_filename2")
    })
    BillingResponseDTO findById(@Param("billing") Billing billing);

    @Insert("INSERT INTO billing " +
            "(`bl_id`, " +
            "`bl_work_date`, " +
            "`cl_id`, " +
            "`cst_code`, " +
            "`bl_pub_date`, " +
            "`bl_supp_value`, " +
            "`bl_tax`, " +
            "`bl_total_value`, " +
            "`bl_collect_date`, " +
            "`bl_difference`, " +
            "bl_uuid1," +
            "bl_filename1, " +
            "bl_uuid2, " +
            "bl_filename2) " +
            "VALUES " +
            "(#{billing.bl_id}, " +
            "#{billing.bl_work_date}, " +
            "#{billing.cl_id}, " +
            "#{billing.cst_code}, " +
            "#{billing.bl_pub_date}, " +
            "#{billing.bl_supp_value}, " +
            "#{billing.bl_tax}, " +
            "#{billing.bl_total_value}, " +
            "#{billing.bl_collect_date}, " +
            "#{billing.bl_difference}, " +
            "#{billing.bl_uuid1}, " +
            "#{billing.bl_filename1}, " +
            "#{billing.bl_uuid2}, " +
            "#{billing.bl_filename2})")
    int register(@Param("billing") Billing billing);

    @Update("UPDATE billing " +
            "SET " +
            "`bl_id` = #{billing.bl_id}, " +
            "`bl_work_date` = #{billing.bl_work_date}, " +
            "`cl_id` = #{billing.cl_id}, " +
            "`cst_code` = #{billing.cst_code}, " +
            "`bl_pub_date` = #{billing.bl_pub_date}, " +
            "`bl_supp_value` = #{billing.bl_supp_value}, " +
            "`bl_tax` = #{billing.bl_tax}, " +
            "`bl_total_value` = #{billing.bl_total_value}, " +
            "`bl_collect_date` = #{billing.bl_collect_date}, " +
            "`bl_difference` = #{billing.bl_difference} " +
            "bl_uuid1 = #{billing.bl_uuid1}, " +
            "bl_filename1 = #{billing.bl_filename1}, " +
            "bl_uuid2 = #{billing.bl_uuid2}, " +
            "bl_filename2 = #{billing.bl_filename2} " +
            "WHERE (`bl_id` = #{billing.bl_id})")
    int update(@Param("billing") Billing billing);

    @Delete("DELETE FROM billing WHERE bl_id = #{billing.bl_id}")
    int delete(@Param("billing") Billing billing);

    List<BillingResponseDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

}
