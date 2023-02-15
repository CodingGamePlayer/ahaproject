package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDTO {

    String cp_name;
    String cl_code;
    String cst_code;
    Long out_supp_value;
    Long out_collect_value;
    Long  out_collect_remain;
    Long  in_supp_value;
    Long  in_collect_value;
    Long in_collect_remain;
}
