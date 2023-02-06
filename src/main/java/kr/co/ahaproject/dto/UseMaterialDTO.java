package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UseMaterialDTO {
    Long um_id;
    String mt_code;
    String cst_code;
    String um_where;
    Long um_amount;
    Boolean um_regit;
}
