package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaborCostListDTO {
    Long lc_id;
    String emp_name;
    String cst_name;
    String cp_name;
    Long lc_value;
    String lc_date;
    boolean lc_regit;
}
