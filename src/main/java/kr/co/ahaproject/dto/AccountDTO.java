package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    int ac_id;
    int cp_id;
    String username;
    String ac_password;
    String ac_person_name;
    String ac_role;
    String ac_regdate;


}
