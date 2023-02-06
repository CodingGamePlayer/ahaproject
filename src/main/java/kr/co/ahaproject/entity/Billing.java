package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    Long bl_id;
    String bl_work_date;
    String cp_name;
    String cst_code;
    String bl_pub_date;
    Long bl_supp_value;
    Long bl_tax;
    Long bl_total_value;
    String bl_collect_date;
    Long bl_difference;

}
