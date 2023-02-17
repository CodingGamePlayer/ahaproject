package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillingResponseDTO {

    Long bl_id;
    String bl_work_date;
    int cl_id;
    String cst_code;
    String bl_pub_date;
    Long bl_supp_value;
    Long bl_tax;
    Long bl_total_value;
    String bl_collect_date;
    Long bl_difference;
    String cp_name;
    String cl_code;
    String cst_name;
}
