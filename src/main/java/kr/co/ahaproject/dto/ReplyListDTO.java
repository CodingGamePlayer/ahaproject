package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyListDTO {

    int rp_id;
    int b_id;
    int ac_id;
    String rp_body;
    String ac_username;
    String ac_person_name;
}
