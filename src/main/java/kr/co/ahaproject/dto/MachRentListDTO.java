package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachRentListDTO {

    Long rent_id;
    String cst_name;
    String rent_start;
    String rent_end;
    String rent_bill_date;
    String m_name;
    Long rent_supp_value;
    Long rent_tax;
    String rent_collect_date;
    Long rent_collect_value;
    Long rent_misu;
    String rent_etc;
    boolean rent_finished;
}
