package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardListDTO {

    int b_id;
    int c_id;
    String ct_name;
    String b_title;
    String b_body;
    int ac_id;
    String ac_username;
    String ac_person_name;
    String b_regit_date;
    String b_modi_date;
    String b_uuid;
    String b_filename;

}
