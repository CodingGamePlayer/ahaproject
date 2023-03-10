package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachRentDTO {
    Long rent_id;
    String cst_code;
    String rent_start;
    String rent_end;
    String rent_bill_date;
    String m_code;
    Long rent_supp_value;
    Long rent_tax;
    String rent_collect_date;
    Long rent_collect_value;
    Long rent_misu;
    Boolean rent_finished;
    String rent_etc;
}