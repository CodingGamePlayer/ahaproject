package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutcomeDTO {
    Long out_id;
    String cl_code;
    String cst_code;
    String cp_name;
    Long out_supp_value;
    Long out_total_value;
    Long out_collect_value;
    Long out_collect_remain;

    String out_date;
    String out_content;
}
