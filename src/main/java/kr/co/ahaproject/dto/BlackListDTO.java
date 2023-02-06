package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlackListDTO {

    Long black_id;
    String cp_name;
    String cp_num;
    String cl_code;
    Long black_total_misu;
    String black_etc;
}
