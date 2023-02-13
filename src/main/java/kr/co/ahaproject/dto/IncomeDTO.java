package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDTO {
    Long in_id;
    String cl_code;
    String cst_code;
    String cp_name;
    Long in_supp_value;
    Long in_total_value;
    Long in_collect_value;
    Long in_collect_remain;
    String in_date;
    String in_content;
}
