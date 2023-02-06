package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConReply {

    Long rp_id;
    Long cst_id;
    String rp_title;
    String rp_body;
    String rp_reg_date;
    String rp_mod_date;
    Boolean rp_finished;
}
