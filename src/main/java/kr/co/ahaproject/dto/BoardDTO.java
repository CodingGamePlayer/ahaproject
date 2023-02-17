package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    int b_id;
    int ct_id;
    int ac_id;
    String b_title;
    String b_body;
    String b_filename;
    String b_uuid;
    String b_regit_date;
    String b_modi_date;
}
