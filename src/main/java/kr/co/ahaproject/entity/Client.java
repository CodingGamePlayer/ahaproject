package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    int cl_id;
    String cp_name;
    String cp_num;
    String cp_address;
    String cp_tel;
    String cl_code;
    String cl_email;
    String cl_account;
    String cl_file;
    String cl_etc1;
    String cl_etc2;
    String cl_etc3;
    String cl_uuid;
    String cl_filename;
}
