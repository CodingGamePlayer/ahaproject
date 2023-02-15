package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionDTO {

    int cst_id;
    String cst_code;
    String cst_name;
    String cst_period;
    String cst_start;
    String cst_end;
    boolean cst_finised;
    String cst_etc1;
    String cst_etc2;
    String cst_etc3;
    String cst_filename;
    String cst_uuid;
}
