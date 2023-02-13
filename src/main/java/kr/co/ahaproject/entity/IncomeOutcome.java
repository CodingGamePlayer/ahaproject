package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeOutcome {
    Long io_id;
    String cl_code;
    String cst_code;
    String cp_name;
    Long out_supp_value;
    Long out_total_value;
    Long out_collect_value;
    Long out_collect_remain;
    Long in_supp_value;
    Long in_total_value;
    Long in_collect_value;
    Long in_collect_remain;
    String io_date;
    String io_content;
}
