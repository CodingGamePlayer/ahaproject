package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaborCostDTO {
    Long lc_id;
    String emp_code;
    String cst_code;
    String cp_name;
    Long lc_value;
    String lc_date;
    Boolean lc_regit;
}
