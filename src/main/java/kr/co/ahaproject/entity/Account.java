package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    int ac_id;
    String cp_name;
    String username;
    String ac_password;
    String ac_person_name;
    String ac_role;
    String ac_regdate;

}
