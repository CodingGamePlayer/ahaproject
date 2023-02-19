package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {

    Long bl_id;
    String bl_work_start_date;
    String bl_work_end_date;
    int cl_id;
    String cst_code;
    String bl_pub_date;
    Long bl_supp_value;
    Long bl_tax;
    Long bl_total_value;
    String bl_collect_date;
    Long bl_difference;
    String bl_uuid1;
    String bl_filename1;
    String bl_uuid2;
    String bl_filename2;
    String bl_etc;
}
