package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Construction {

    int cst_id;
    String cst_code;
    String cst_name;
    String cst_period;
    String cst_start;
    String cst_end;
    Long cst_toal_pay;
    Long cst_1st_pay;
    String cst_collect_date;
    boolean cst_finised;
    String cst_etc1;
    String cst_etc2;
    String cst_etc3;
    String cst_filename;
    String cst_uuid;
}
